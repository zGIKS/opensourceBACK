package quri.teelab.api.teelab.designlab.model.valueobjects;

import java.util.UUID;

public record UserId(UUID userId) {
    public UserId {
        if (userId == null || userId.toString().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
    }
}
