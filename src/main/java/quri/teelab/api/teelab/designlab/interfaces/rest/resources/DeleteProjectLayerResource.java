package quri.teelab.api.teelab.designlab.interfaces.rest.resources;

import java.util.UUID;

public record DeleteProjectLayerResource(UUID layerId, UUID projectId) {
    public DeleteProjectLayerResource {
        if (layerId == null) {
            throw new IllegalArgumentException("Layer ID cannot be null");
        }
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
    }
}
