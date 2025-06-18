package quri.teelab.api.teelab.designlab.domain.model.queries;

import java.util.UUID;

public record GetProjectByIdQuery(UUID projectId) {
    public GetProjectByIdQuery {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
    }
}
