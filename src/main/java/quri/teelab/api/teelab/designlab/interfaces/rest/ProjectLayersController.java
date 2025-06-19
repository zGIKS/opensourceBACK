package quri.teelab.api.teelab.designlab.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quri.teelab.api.teelab.designlab.domain.services.ProjectCommandService;
import quri.teelab.api.teelab.designlab.domain.services.ProjectQueryService;
import quri.teelab.api.teelab.designlab.interfaces.rest.transform.DeleteProjectLayerCommandFromResourceAssembler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/projects/layers", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Design Lab", description = "Available Project Layer Endpoints")
public class ProjectLayersController {
    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;

    public ProjectLayersController(ProjectCommandService projectCommandService, ProjectQueryService projectQueryService) {
        this.projectCommandService = projectCommandService;
        this.projectQueryService = projectQueryService;
    }

    @DeleteMapping("/{projectId}/layer/{layerId}")
    @Operation(summary = "Delete Layer from Project", description = "Delete a layer from a project by its unique identifiers")
    public ResponseEntity<?> deleteProjectLayerById(@PathVariable String projectId, @PathVariable String layerId) {
        var command = DeleteProjectLayerCommandFromResourceAssembler.toCommandFromResource(projectId, layerId);

        var deletedLayerId = projectCommandService.handle(command);

        if (deletedLayerId == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Layer with ID " + deletedLayerId + " has been successfully deleted from project with ID " + projectId);
    }
}
