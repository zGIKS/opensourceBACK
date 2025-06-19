package quri.teelab.api.teelab.designlab.domain.model.queries;

import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;

public record GetProjectByIdQuery(ProjectId projectId) {
    public GetProjectByIdQuery {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
    }
}

