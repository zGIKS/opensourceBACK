package quri.teelab.api.teelab.designlab.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quri.teelab.api.teelab.designlab.domain.model.queries.GetAllProjectsByUserIdQuery;
import quri.teelab.api.teelab.designlab.domain.services.ProjectCommandService;
import quri.teelab.api.teelab.designlab.domain.services.ProjectQueryService;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.ProjectResource;
import quri.teelab.api.teelab.designlab.interfaces.rest.transform.ProjectResourceFromEntityAssembler;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/projects", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Design Lab", description = "Available Project Endpoints")
public class ProjectsController {
    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;

    public ProjectsController(ProjectCommandService projectCommandService, ProjectQueryService projectQueryService) {
        this.projectCommandService = projectCommandService;
        this.projectQueryService = projectQueryService;
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<List<ProjectResource>> getAllProjectsByUserIdQuery(@PathVariable String userId) {
        var getAllProjectsByUserIdQuery = new GetAllProjectsByUserIdQuery(UUID.fromString(userId));

        var projects = projectQueryService.handle(getAllProjectsByUserIdQuery);

        var projectsResource = projects.stream().map(ProjectResourceFromEntityAssembler::toResourceFromEntity).toList();

        return ResponseEntity.ok(projectsResource);
    }
}
