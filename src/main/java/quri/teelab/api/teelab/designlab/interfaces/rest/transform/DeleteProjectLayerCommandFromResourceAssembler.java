package quri.teelab.api.teelab.designlab.interfaces.rest.transform;

import quri.teelab.api.teelab.designlab.domain.model.commands.DeleteProjectLayerCommand;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;

public class DeleteProjectLayerCommandFromResourceAssembler {
    public static DeleteProjectLayerCommand toCommandFromResource(String projectId, String layerId) {
        if (projectId == null || projectId.isBlank()) {
            throw new IllegalArgumentException("Project ID cannot be null or blank");
        }
        if (layerId == null || layerId.isBlank()) {
            throw new IllegalArgumentException("Layer ID cannot be null or blank");
        }

        return new DeleteProjectLayerCommand(
                ProjectId.of(projectId),
                LayerId.of(layerId)
        );

    }
}
