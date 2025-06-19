package quri.teelab.api.teelab.designlab.domain.model.commands;

import java.util.UUID;

public record SendLayerToBackCommand(UUID projectId, UUID layerId) {
    public SendLayerToBackCommand {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
        if (layerId == null) {
            throw new IllegalArgumentException("Layer ID cannot be null");
        }
    }
}
