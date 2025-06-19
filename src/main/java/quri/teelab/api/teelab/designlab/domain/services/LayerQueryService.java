package quri.teelab.api.teelab.designlab.domain.services;

import quri.teelab.api.teelab.designlab.domain.model.entities.Layer;
import quri.teelab.api.teelab.designlab.domain.model.queries.GetLayerByIdQuery;

public interface LayerQueryService {

    public Layer handle(GetLayerByIdQuery query);
}
