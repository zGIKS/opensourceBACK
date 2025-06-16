package quri.teelab.api.teelab.designlab.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record UserId(UUID userId) {
    public UserId {
        if (userId == null || userId.toString().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
    }
}
