package quri.teelab.api.teelab.productcatalog.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Value object representing a reference to a Project entity from the DesignLab bounded context.
 * This is part of the anti-corruption layer between ProductCatalog and DesignLab contexts.
 */
@Embeddable
public record ProjectId(String value) implements Serializable {
    
    /**
     * Creates a new ProjectId with validation.
     */
    public ProjectId {
        Objects.requireNonNull(value, "Project ID cannot be null");
        if (value.isBlank()) {
            throw new IllegalArgumentException("Project ID cannot be blank");
        }
    }
    
    /**
     * Default constructor for JPA.
     */
    public ProjectId() {
        this("");
    }
    
    /**
     * Factory method to create a ProjectId from a string.
     *
     * @param id The string representation of the project ID
     * @return A new ProjectId instance
     */
    public static ProjectId of(String id) {
        return new ProjectId(id);
    }
    
    /**
     * Factory method for creating a ProjectId from a UUID value.
     * This is useful for integration with systems that use UUID project IDs.
     *
     * @param id The UUID project ID
     * @return A new ProjectId instance
     */
    public static ProjectId of(UUID id) {
        return new ProjectId(id.toString());
    }
    
    @Override
    public String toString() {
        return value;
    }
}
