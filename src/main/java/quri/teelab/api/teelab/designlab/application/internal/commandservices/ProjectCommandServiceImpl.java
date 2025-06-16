package quri.teelab.api.teelab.designlab.application.internal.commandservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.designlab.domain.model.commands.DeleteProjectLayerCommand;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;
import quri.teelab.api.teelab.designlab.domain.services.ProjectCommandService;
import quri.teelab.api.teelab.designlab.infrastructure.persistence.jpa.repositories.ProjectRepository;

import java.util.UUID;

@Service
public class ProjectCommandServiceImpl implements ProjectCommandService {
    private final ProjectRepository projectRepository;

    public ProjectCommandServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public UUID handle(DeleteProjectLayerCommand command) {

        // TODO: Check this with the teacher if this is the correct way to handle the command
        if (!projectRepository.existsById(command.projectId())) {
            throw new IllegalArgumentException("Project with ID " + command.projectId() + " does not exist.");
        }

        try {
            // TODO: Implement the logic to delete the project layer
            // projectRepository.deleteById(command.projectId());
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete project with ID " + command.projectId(), e);
        }

        return command.projectId();
    }
}
