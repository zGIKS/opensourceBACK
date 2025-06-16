package quri.teelab.api.teelab.designlab.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record LayerId(UUID layerId) {
}
