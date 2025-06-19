package quri.teelab.api.teelab.designlab.domain.model.commands;


import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;

import java.util.UUID;

public record DeleteProjectLayerCommand(ProjectId projectId, LayerId layerId) {
    public DeleteProjectLayerCommand {
        if (projectId == null) {
            throw new IllegalArgumentException("Project ID cannot be null");
        }
        if (layerId == null) {
            throw new IllegalArgumentException("Layer ID cannot be null");
        }
    }
}
