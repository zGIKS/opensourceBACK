package quri.teelab.api.teelab.designlab.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record LayerId(UUID layerId) {
    public LayerId {
        if (layerId == null) {
            throw new IllegalArgumentException("LayerId cannot be null");
        }
    }
}
