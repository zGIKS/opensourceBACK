package quri.teelab.api.teelab.designlab.interfaces.rest.resources;

import quri.teelab.api.teelab.designlab.domain.model.valueobjects.GarmentColor;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.GarmentGender;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.GarmentSize;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectStatus;

import java.util.List;
import java.util.UUID;

public record ProjectResource(
        UUID id, 
        String title, 
        UUID userId,
        String previewUrl,
        ProjectStatus status,
        GarmentColor garmentColor,
        GarmentSize garmentSize,
        GarmentGender garmentGender,
        List<LayerResource> layers,
        String createdAt, 
        String updatedAt
) {

    public ProjectResource {
        if (id == null || title == null || userId == null) {
            throw new IllegalArgumentException("ProjectResource fields cannot be null");
        }
    }
}
