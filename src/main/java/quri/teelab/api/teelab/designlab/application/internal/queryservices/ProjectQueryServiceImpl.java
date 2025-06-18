package quri.teelab.api.teelab.designlab.application.internal.queryservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.designlab.domain.model.aggregates.Project;
import quri.teelab.api.teelab.designlab.domain.model.queries.GetAllProjectsByUserIdQuery;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.UserId;
import quri.teelab.api.teelab.designlab.domain.services.ProjectQueryService;
import quri.teelab.api.teelab.designlab.infrastructure.persistence.jpa.repositories.ProjectRepository;

import java.util.List;

@Service
public class ProjectQueryServiceImpl implements ProjectQueryService {
    private final ProjectRepository projectRepository;

    public ProjectQueryServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public List<Project> handle(GetAllProjectsByUserIdQuery query) {
        // Validate if there is a Project With the given User ID
        if (!projectRepository.existsByUserId(query.userId())) {
            System.out.println("No projects found for user ID: " + query.userId());
            throw new IllegalArgumentException("No projects found for the given user ID");
        }

        // Fetch all projects for the given User ID
        var userId = new UserId(query.userId());

        var projects = projectRepository.findAllByUserId(userId);
        if (projects.isEmpty()) {
            return List.of(); // Return an empty list if no projects are found
        }

        // Return the list of projects
        return projects;
    }

}
