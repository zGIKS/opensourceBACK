package quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public record ProductId(UUID value) implements Serializable {
    public ProductId {
        if (value == null) {
            throw new IllegalArgumentException("ProductId cannot be null");
        }
    }

    public static ProductId newId() {
        return new ProductId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
