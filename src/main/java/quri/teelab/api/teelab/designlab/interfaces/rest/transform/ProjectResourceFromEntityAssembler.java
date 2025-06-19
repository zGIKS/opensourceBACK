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
                .map(ProjectResourceFromEntityAssembler::toLayerResource)
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
    
    private static LayerResource toLayerResource(Layer layer) {
        Map<String, Object> details = new HashMap<>();
        
        if (layer.getType() == LayerType.TEXT) {
            TextLayer textLayer = (TextLayer) layer;
            details.put("text", textLayer.getText());
            details.put("fontColor", textLayer.getFontColor());
            details.put("fontFamily", textLayer.getFontFamily());
            details.put("fontSize", textLayer.getFontSize());
            details.put("isBold", textLayer.getIsBold());
            details.put("isItalic", textLayer.getIsItalic());
            details.put("isUnderlined", textLayer.getIsUnderlined());
        } else if (layer.getType() == LayerType.IMAGE) {
            ImageLayer imageLayer = (ImageLayer) layer;
            details.put("imageUrl", imageLayer.getImageUrl());
            details.put("width", imageLayer.getWidth());
            details.put("height", imageLayer.getHeight());
        }
        
        return new LayerResource(
            layer.getId().layerId(),
            layer.getX(),
            layer.getY(),
            layer.getZ(),
            layer.getOpacity(),
            layer.isVisible(),
            layer.getType(),
            layer.getCreatedAt().toString(),
            layer.getUpdatedAt().toString(),
            details.isEmpty() ? null : details
        );
    }
}
