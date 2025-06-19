package quri.teelab.api.teelab.designlab.interfaces.rest.transform;

import quri.teelab.api.teelab.designlab.domain.model.commands.CreateTextLayerCommand;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.CreateTextLayerResource;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;

import java.util.UUID;

public class CreateTextLayerCommandFromResourceAssembler {
    public static CreateTextLayerCommand ToCommandFromResource(CreateTextLayerResource resource) {
        return new CreateTextLayerCommand(
                ProjectId.of(resource.projectId()),
                resource.text(),
                resource.fontColor(),
                resource.fontFamily(),
                resource.fontSize(),
                resource.isBold(),
                resource.isItalic(),
                resource.isUnderlined()
        );
    }
}
