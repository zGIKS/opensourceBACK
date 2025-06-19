package quri.teelab.api.teelab.designlab.interfaces.rest.transform;

import quri.teelab.api.teelab.designlab.domain.model.entities.ImageLayer;
import quri.teelab.api.teelab.designlab.domain.model.entities.Layer;
import quri.teelab.api.teelab.designlab.domain.model.entities.TextLayer;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerType;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.LayerResource;

import java.util.HashMap;
import java.util.Map;

public class LayerResourceFromEntityAssembler {

    public static LayerResource toResourceFromEntity(Layer layer) {
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
