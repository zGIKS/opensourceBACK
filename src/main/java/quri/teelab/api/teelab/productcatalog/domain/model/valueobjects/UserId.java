package quri.teelab.api.teelab.productcatalog.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Value object representing a reference to a User within the Product Catalog domain.
 * 
 * This is an intentionally simplified identifier that contains only what the Product Catalog
 * domain needs to know about a User, without any implementation details of external systems.
 * The Application layer's ACL is responsible for translating between this simple identifier
 * and any external system representations.
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
     * Factory method for creating a UserId from a UUID value.
     * This is useful for integration with systems that use UUID user IDs.
     *
     * @param id The UUID user ID
     * @return A new UserId instance
     */
    public static UserId of(UUID id) {
        return new UserId(id.toString());
    }
    
    @Override
    public String toString() {
        return value;
    }
}
