package quri.teelab.api.teelab.designlab.domain.model.queries;

import quri.teelab.api.teelab.designlab.domain.model.valueobjects.UserId;

public record GetAllProjectsByUserIdQuery(UserId userId) {
    public GetAllProjectsByUserIdQuery {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
    }
}
