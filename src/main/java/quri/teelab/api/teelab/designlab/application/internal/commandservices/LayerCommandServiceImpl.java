package quri.teelab.api.teelab.designlab.application.internal.commandservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.designlab.domain.model.commands.CreateImageLayerCommand;
import quri.teelab.api.teelab.designlab.domain.model.commands.CreateTextLayerCommand;
import quri.teelab.api.teelab.designlab.domain.model.entities.ImageLayer;
import quri.teelab.api.teelab.designlab.domain.model.entities.TextLayer;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.domain.services.LayerCommandService;
import quri.teelab.api.teelab.designlab.infrastructure.persistence.jpa.repositories.LayerRepository;
import quri.teelab.api.teelab.designlab.infrastructure.persistence.jpa.repositories.ProjectRepository;

import java.util.UUID;

@Service
public class LayerCommandServiceImpl implements LayerCommandService {
    private final ProjectRepository projectRepository;
    private final LayerRepository layerRepository;

    public LayerCommandServiceImpl(ProjectRepository projectRepository, LayerRepository layerRepository) {
        this.projectRepository = projectRepository;
        this.layerRepository = layerRepository;
    }

    @Override
    public LayerId handle(CreateTextLayerCommand command) {
        LayerId layerId = new LayerId(UUID.randomUUID());

        var project = projectRepository.
                findById(command.projectId()).
                orElseThrow(() -> new IllegalArgumentException("Project with ID " + command.projectId() + " does not exist."));

        var layer = new TextLayer(command);

        try {
            project.addLayer(layer);
            layerRepository.save(layer);
            return layerId;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create text layer", e);
        }
    }

    @Override
    public LayerId handle(CreateImageLayerCommand command) {
        LayerId layerId = new LayerId(UUID.randomUUID());

        // Here should be a validation for the user id

        var project = projectRepository
                .findById(command.projectId())
                .orElseThrow(() -> new IllegalArgumentException("Project with ID " + command.projectId() + " does not exist."));

        var layer = new ImageLayer(command);

        try {
            project.addLayer(layer);
            layerRepository.save(layer);
            return layerId;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create image layer", e);
        }
    }
}
