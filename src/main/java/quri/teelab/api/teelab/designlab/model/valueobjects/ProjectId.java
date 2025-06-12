package quri.teelab.api.teelab.designlab.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ProjectId(UUID projectId) {

    public ProjectId {
        if (projectId == null || projectId.toString().isEmpty()) {
            throw new IllegalArgumentException("Project ID cannot be null or empty");
        }
    }
}
