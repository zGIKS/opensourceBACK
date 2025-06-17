package quri.teelab.api.teelab.orderfulfillment.domain.services;

import quri.teelab.api.teelab.orderfulfillment.domain.model.commands.CreateFulfillmentCommand;

public interface FulfillmentCommandService {
    Long handle(CreateFulfillmentCommand command);
}
