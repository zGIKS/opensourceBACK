package quri.teelab.api.teelab.designlab.domain.model.commands;

import java.util.UUID;

public record UpdateImageLayerCommand(UUID projectId, UUID layerId, String imageUrl) {
    public UpdateImageLayerCommand {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
        if (layerId == null) {
            throw new IllegalArgumentException("Layer ID cannot be null");
        }
        if (imageUrl == null || imageUrl.isBlank()) {
            throw new IllegalArgumentException("Image URL cannot be null or blank");
        }
    }
}
