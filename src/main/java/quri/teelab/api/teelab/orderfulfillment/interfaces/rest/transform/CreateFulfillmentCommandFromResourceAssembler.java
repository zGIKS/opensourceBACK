package quri.teelab.api.teelab.orderfulfillment.interfaces.rest.transform;

import quri.teelab.api.teelab.orderfulfillment.domain.model.commands.CreateFulfillmentCommand;
import quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources.CreateFulfillmentResource;

public class CreateFulfillmentCommandFromResourceAssembler {
    
    public static CreateFulfillmentCommand toCommandFromResource(CreateFulfillmentResource resource) {
        return new CreateFulfillmentCommand(
                resource.orderId(),
                resource.manufacturerId()
        );
    }
}
