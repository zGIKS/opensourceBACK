package quri.teelab.api.teelab.designlab.application.internal.commandservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.designlab.domain.model.aggregates.Project;
import quri.teelab.api.teelab.designlab.domain.model.commands.CreateProjectCommand;
import quri.teelab.api.teelab.designlab.domain.model.commands.DeleteProjectLayerCommand;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;
import quri.teelab.api.teelab.designlab.domain.services.ProjectCommandService;
import quri.teelab.api.teelab.designlab.infrastructure.persistence.jpa.repositories.LayerRepository;
import quri.teelab.api.teelab.designlab.infrastructure.persistence.jpa.repositories.ProjectRepository;

import java.util.UUID;

@Service
public class ProjectCommandServiceImpl implements ProjectCommandService {
    private final ProjectRepository projectRepository;
    private final LayerRepository layerRepository;

    public ProjectCommandServiceImpl(ProjectRepository projectRepository, LayerRepository layerRepository) {
        this.projectRepository = projectRepository;
        this.layerRepository = layerRepository;
    }

    @Override
    public LayerId handle(DeleteProjectLayerCommand command) {
        var layerId = command.layerId();

        if (!layerRepository.existsById(command.layerId())) {
            throw new IllegalArgumentException("Layer with ID " + command.layerId() + " does not exist.");
        }

        var result = projectRepository.findById(command.projectId());

        if (result.isEmpty()) {
            throw new IllegalArgumentException("Project with ID " + command.projectId() + " does not exist.");
        }

        var project = result.get();
        try {
            if (project.hasLayerWithId(command.layerId())) {
                // TODO: Ask if we should delete the layer from the project or just remove it from the repository
                layerRepository.deleteById(command.layerId());
                return command.layerId();
            }
            throw new IllegalArgumentException("Project with ID " + command.projectId() + " does not have a layer with ID " + command.layerId() + ".");
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete project with ID " + command.projectId(), e);
        }
    }

    @Override
    public ProjectId handle(CreateProjectCommand command) {
        // Here should be a validation for the user id

        var project = new Project(command);

        try {
            projectRepository.save(project);
            return project.getId();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create project", e);
        }

    }
}
