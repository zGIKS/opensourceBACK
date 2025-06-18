package quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ManufacturerId(UUID manufacturerId) {
    public ManufacturerId {
        if (manufacturerId == null) {
            throw new IllegalArgumentException("Manufacturer ID cannot be null");
        }
    }
}
