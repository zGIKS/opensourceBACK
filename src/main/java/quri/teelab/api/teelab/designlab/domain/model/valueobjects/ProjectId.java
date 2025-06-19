package quri.teelab.api.teelab.designlab.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ProjectId(UUID projectId) {

    public ProjectId {
        if (projectId == null || projectId.toString().isEmpty()) {
            throw new IllegalArgumentException("Project ID cannot be null or empty");
        }
    }

    public static ProjectId of(String projectId) {
        if (projectId == null || projectId.isBlank()) {
            throw new IllegalArgumentException("Project ID cannot be null or blank");
        }
        var uuid = UUID.fromString(projectId);

        return new ProjectId(uuid);
    }
}
