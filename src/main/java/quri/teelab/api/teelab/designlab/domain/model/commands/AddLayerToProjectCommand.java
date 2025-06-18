package quri.teelab.api.teelab.designlab.domain.model.commands;

import java.util.UUID;

public record AddLayerToProjectCommand(UUID projectId, String layerType) {
    public AddLayerToProjectCommand {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
        if (layerType == null || layerType.isBlank()) {
            throw new IllegalArgumentException("Layer type cannot be null or blank");
        }
    }
}
