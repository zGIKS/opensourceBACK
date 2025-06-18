package quri.teelab.api.teelab.productcatalog.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.io.Serializable;
import java.util.UUID;

/**
 * Value object representing a reference to a Manufacturer within the Product Catalog domain.
 * <p>
 * This is an intentionally simplified identifier that contains only what the Product Catalog
 * domain needs to know about a Manufacturer, without any implementation details of external systems.
 * The Application layer's ACL is responsible for translating between this simple identifier
 * and any external system representations.
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
     * Factory method for creating a ManufacturerId from a UUID value.
     * This is useful for integration with systems that use UUID manufacturer IDs.
     *
     * @param id The UUID manufacturer ID
     * @return A new ManufacturerId instance
     */
    public static ManufacturerId of(UUID id) {
        return new ManufacturerId(id.toString());
    }

    @Override
    public String toString() {
        return value;
    }
}
