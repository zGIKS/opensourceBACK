package quri.teelab.api.teelab.designlab.interfaces.rest.transform;

import quri.teelab.api.teelab.designlab.domain.model.entities.Layer;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.LayerResource;

public class LayerResourceFromEntityAssembler {

    public static Layer toResourceFromEntity(Layer layerEntity) {
        if (layerEntity == null) {
            throw new IllegalArgumentException("LayerResource cannot be null");
        }

        return new LayerResource(
            layerEntity.getId(),
            layerEntity.getProjectId(),
            layerEntity.getType(),
            layerEntity.getContent(),
            layerEntity.getPosition(),
            layerEntity.getSize()
        );
    }
}
