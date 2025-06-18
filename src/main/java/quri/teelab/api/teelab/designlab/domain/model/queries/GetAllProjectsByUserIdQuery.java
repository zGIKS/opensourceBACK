package quri.teelab.api.teelab.designlab.domain.model.queries;

import java.util.UUID;

public record GetAllProjectsByUserIdQuery(UUID userId) {
    public GetAllProjectsByUserIdQuery {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
    }
}
