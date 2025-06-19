package quri.teelab.api.teelab.designlab.domain.model.commands;

import java.util.UUID;

public record UpdateVideoLayerCommand(UUID projectId, UUID layerId, String videoUrl) {
    public UpdateVideoLayerCommand {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
        if (layerId == null) {
            throw new IllegalArgumentException("Layer ID cannot be null");
        }
        if (videoUrl == null || videoUrl.isBlank()) {
            throw new IllegalArgumentException("Video URL cannot be null or blank");
        }
    }
}
