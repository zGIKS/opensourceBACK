package quri.teelab.api.teelab.designlab.domain.model.queries;

import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;

public record GetLayerByIdQuery(LayerId layerId) {

    public GetLayerByIdQuery {
        if (layerId == null) {
            throw new IllegalArgumentException("Layer ID cannot be null or blank");
        }
    }
}
