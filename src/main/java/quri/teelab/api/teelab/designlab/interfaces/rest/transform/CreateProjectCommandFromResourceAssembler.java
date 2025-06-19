package quri.teelab.api.teelab.designlab.interfaces.rest.transform;

import quri.teelab.api.teelab.designlab.domain.model.commands.CreateProjectCommand;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.UserId;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.CreateProjectResource;

import java.util.UUID;

public class CreateProjectCommandFromResourceAssembler {
    public static CreateProjectCommand CreateProjectCommandFromResourceAssembler(CreateProjectResource createProjectResource) {
        if (createProjectResource == null) {
            throw new IllegalArgumentException("CreateProjectResource cannot be null");
        }

        return new CreateProjectCommand(
                new UserId(UUID.fromString(createProjectResource.title())),
                createProjectResource.title(),
                createProjectResource.garmentColor()
        );
    }
}
