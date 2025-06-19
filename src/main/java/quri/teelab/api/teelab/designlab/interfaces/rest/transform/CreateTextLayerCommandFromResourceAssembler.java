package quri.teelab.api.teelab.designlab.interfaces.rest.transform;

import quri.teelab.api.teelab.designlab.domain.model.commands.CreateTextLayerCommand;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.CreateTextLayerResource;

public class CreateTextLayerCommandFromResourceAssembler {


    public static CreateTextLayerCommand ToCommandFromResource (CreateTextLayerResource resource) {
        return new CreateTextLayerCommand(

        );
    }
}
