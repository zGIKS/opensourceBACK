package quri.teelab.api.teelab.productcatalog.domain.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Embeddable
public record Money(
    @Column(name = "amount")
    BigDecimal amount,
    
    @Column(name = "currency", length = 3)
    Currency currency
) {
    
    public static final Currency DEFAULT_CURRENCY = Currency.getInstance("PEN"); // Peruvian Sol
    
    /**
     * Primary constructor that validates and scales the monetary amount
     */
    @JsonCreator
    public Money {
        // Perform validation and normalization in compact constructor
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        amount = amount.setScale(2, RoundingMode.HALF_EVEN);
    }
    
    // JPA requires a no-arg constructor for embeddable types
    public Money() {
        this(BigDecimal.ZERO, DEFAULT_CURRENCY);
    }
    
    /**
     * Convenience constructor with default currency
     */
    public Money(BigDecimal amount) {
        this(amount, DEFAULT_CURRENCY);
    }
    
    public static Money of(BigDecimal amount) {
        return new Money(amount);
    }
    
    public static Money of(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }
      public Money add(Money other) {
        validateSameCurrency(other);
        return new Money(this.amount.add(other.amount), this.currency);
    }
    
    public Money subtract(Money other) {
        validateSameCurrency(other);
        return new Money(this.amount.subtract(other.amount), this.currency);
    }
    
    public Money multiply(int multiplier) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(multiplier)), this.currency);
    }
    
    private void validateSameCurrency(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot operate on money with different currencies");
        }
    }
    
    /**
     * Returns a formatted string representation of this money value,
     * including the currency symbol and amount.
     *
     * @return Formatted string with currency symbol and amount
     */
    public String formatted() {
        return currency.getSymbol() + " " + amount;
    }
    
    /**
     * Override toString to provide a more useful representation
     */
    @Override
    public String toString() {
        return formatted();
    }
}
