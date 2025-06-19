package quri.teelab.api.teelab.designlab.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerType;

import java.util.Map;
import java.util.UUID;

public record LayerResource(
    UUID id,
    int x,
    int y,
    int z,
    Float opacity,
    boolean isVisible,
    LayerType type,
    String createdAt,
    String updatedAt,
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, Object> details
) {
    public LayerResource {
        if (id == null || type == null) {
            throw new IllegalArgumentException("LayerResource fields cannot be null");
        }
    }
}
