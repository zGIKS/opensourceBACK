package quri.teelab.api.teelab.productcatalog.domain.model.valueobjects;

import java.util.Objects;

/**
 * Value object representing a product rating.
 * Ensures ratings stay within valid range and provides utility methods for rating calculation.
 */
public class Rating {
    private final double value;
    private static final double MIN_VALUE = 0.0;
    private static final double MAX_VALUE = 5.0;

    public Rating(double value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("Rating must be between " + MIN_VALUE + " and " + MAX_VALUE);
        }
        this.value = Math.round(value * 10) / 10.0; // Round to one decimal place
    }

    public static Rating of(double value) {
        return new Rating(value);
    }

    public static Rating zero() {
        return new Rating(0);
    }

    public static Rating average(Rating[] ratings) {
        if (ratings.length == 0) {
            return zero();
        }

        double sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getValue();
        }
        return new Rating(sum / ratings.length);
    }

    public double getValue() {
        return value;
    }

    public int getStars() {
        return (int) Math.round(value);
    }

    public boolean isPositive() {
        return value >= 3.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Double.compare(rating.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.format("%.1f/5.0", value);
    }
}
