package quri.teelab.api.teelab.designlab.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record LayerId(UUID layerId) {
    public LayerId {
        if (layerId == null) {
            throw new IllegalArgumentException("LayerId cannot be null");
        }
    }

    public static LayerId of(String layerId) {
        if (layerId == null || layerId.isBlank()) {
            throw new IllegalArgumentException("Layer ID cannot be null or blank");
        }
        var uuid = UUID.fromString(layerId);
        return new LayerId(uuid);
    }
}
