package quri.teelab.api.teelab.productcatalog.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;
import java.io.Serializable;

/**
 * Value object representing a reference to a Manufacturer entity from the ManufacturerManagement bounded context.
 * This is part of the anti-corruption layer between ProductCatalog and ManufacturerManagement contexts.
 */
@Embeddable
public record ManufacturerId(String value) implements Serializable {
    
    /**
     * Creates a new ManufacturerId with validation.
     */
    public ManufacturerId {
        Objects.requireNonNull(value, "Manufacturer ID cannot be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("Manufacturer ID cannot be blank");
        }
    }
    
    /**
     * Default constructor for JPA.
     */
    public ManufacturerId() {
        this("");
    }
    
    /**
     * Factory method to create a ManufacturerId from a string.
     *
     * @param id The string representation of the manufacturer ID
     * @return A new ManufacturerId instance
     */
    public static ManufacturerId of(String id) {
        return new ManufacturerId(id);
    }
    
    /**
     * Factory method for creating a ManufacturerId from a Long value.
     * This is useful for integration with systems that use numeric manufacturer IDs.
     *
     * @param id The numeric manufacturer ID
     * @return A new ManufacturerId instance
     */
    public static ManufacturerId of(Long id) {
        return new ManufacturerId(id.toString());
    }
    
    @Override
    public String toString() {
        return value;
    }
}
