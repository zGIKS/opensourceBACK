package quri.teelab.api.teelab.designlab.application.internal.queryservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.designlab.domain.model.entities.Layer;
import quri.teelab.api.teelab.designlab.domain.model.queries.GetLayerByIdQuery;
import quri.teelab.api.teelab.designlab.domain.services.LayerQueryService;
import quri.teelab.api.teelab.designlab.infrastructure.persistence.jpa.repositories.LayerRepository;

@Service
public class LayerQueryServiceImpl implements LayerQueryService {
    private final LayerRepository layerRepository;

    public LayerQueryServiceImpl(LayerRepository layerRepository) {
        this.layerRepository = layerRepository;
    }

    @Override
    public Layer handle(GetLayerByIdQuery query) {
        if (query.layerId() == null) {
            System.out.println("Layer ID cannot be null or empty.");
            throw new IllegalArgumentException("Layer ID cannot be null or empty.");
        }
        var layer = layerRepository.findById(query.layerId())
                .orElseThrow(() -> new IllegalArgumentException("Layer with ID " + query.layerId() + " does not exist."));

        if (layer == null) {
            System.out.println("Layer with ID " + query.layerId() + " does not exist.");
            throw new IllegalArgumentException("Layer with ID " + query.layerId() + " does not exist.");
        }
        return null;
    }
}
