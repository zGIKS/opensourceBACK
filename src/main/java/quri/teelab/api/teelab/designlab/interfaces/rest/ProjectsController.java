package quri.teelab.api.teelab.designlab.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quri.teelab.api.teelab.designlab.domain.model.queries.GetAllProjectsByUserIdQuery;
import quri.teelab.api.teelab.designlab.domain.model.queries.GetProjectByIdQuery;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.UserId;
import quri.teelab.api.teelab.designlab.domain.services.ProjectCommandService;
import quri.teelab.api.teelab.designlab.domain.services.ProjectQueryService;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.CreateImageLayerResource;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.CreateProjectResource;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.CreateTextLayerResource;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.ProjectResource;
import quri.teelab.api.teelab.designlab.interfaces.rest.transform.CreateProjectCommandFromResourceAssembler;
import quri.teelab.api.teelab.designlab.interfaces.rest.transform.ProjectResourceFromEntityAssembler;

import java.util.List;

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
        var getAllProjectsByUserIdQuery = new GetAllProjectsByUserIdQuery(UserId.of(userId));

        var projects = projectQueryService.handle(getAllProjectsByUserIdQuery);

        var projectsResource = projects.stream().map(ProjectResourceFromEntityAssembler::toResourceFromEntity).toList();

        return ResponseEntity.ok(projectsResource);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> CreateProject(@RequestBody CreateProjectResource resource) {
        var createProjectCommand = CreateProjectCommandFromResourceAssembler.CreateProjectCommandFromResourceAssembler(resource);

        var projectId = projectCommandService.handle(createProjectCommand);

        if (projectId == null) {
            return ResponseEntity.badRequest().build();
        }        // Create ProjectId value object instead of using UUID directly
        var getProjectByIdQuery = new GetProjectByIdQuery(projectId);
        var project = projectQueryService.handle(getProjectByIdQuery);

        if (project == null) {
            return ResponseEntity.notFound().build();
        }

        var projectResource = ProjectResourceFromEntityAssembler.toResourceFromEntity(project);

        return new ResponseEntity<>(projectResource, HttpStatus.CREATED);
    }
}
