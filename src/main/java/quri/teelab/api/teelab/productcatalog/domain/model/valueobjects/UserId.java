package quri.teelab.api.teelab.productcatalog.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;
import java.io.Serializable;

/**
 * Value object representing a reference to a User entity from the UserManagement bounded context.
 * This is part of the anti-corruption layer between ProductCatalog and UserManagement contexts.
 */
@Embeddable
public record UserId(String value) implements Serializable {
    
    /**
     * Creates a new UserId with validation.
     */
    public UserId {
        Objects.requireNonNull(value, "User ID cannot be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be blank");
        }
    }
    
    /**
     * Default constructor for JPA.
     */
    public UserId() {
        this("");
    }
    
    /**
     * Factory method to create a UserId from a string.
     *
     * @param id The string representation of the user ID
     * @return A new UserId instance
     */
    public static UserId of(String id) {
        return new UserId(id);
    }
    
    /**
     * Factory method for creating a UserId from a Long value.
     * This is useful for integration with systems that use numeric user IDs.
     *
     * @param id The numeric user ID
     * @return A new UserId instance
     */
    public static UserId of(Long id) {
        return new UserId(id.toString());
    }
    
    @Override
    public String toString() {
        return value;
    }
}
