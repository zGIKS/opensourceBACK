package quri.teelab.api.teelab.designlab.interfaces.rest.transform;

import quri.teelab.api.teelab.designlab.domain.model.aggregates.Project;
import quri.teelab.api.teelab.designlab.domain.model.entities.ImageLayer;
import quri.teelab.api.teelab.designlab.domain.model.entities.Layer;
import quri.teelab.api.teelab.designlab.domain.model.entities.TextLayer;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerType;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.LayerResource;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.ProjectResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProjectResourceFromEntityAssembler {

    public static ProjectResource toResourceFromEntity(Project entity) {
        List<LayerResource> layers = entity.getLayers().stream()
                .map(LayerResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
                
        return new ProjectResource(
            entity.getId().projectId(),
            entity.getTitle(),
            entity.getUserId().userId(),
            entity.getPreviewUrl(),
            entity.getStatus(),
            entity.getGarmentColor(),
            entity.getGarmentSize(),
            entity.getGarmentGender(),
            layers,
            entity.getCreatedAt().toString(),
            entity.getUpdatedAt().toString()
        );
    }
}
