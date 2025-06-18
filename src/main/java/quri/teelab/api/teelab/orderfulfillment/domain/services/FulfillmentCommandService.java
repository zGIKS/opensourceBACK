package quri.teelab.api.teelab.orderfulfillment.domain.services;

import quri.teelab.api.teelab.orderfulfillment.domain.model.commands.CreateFulfillmentCommand;
import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.FulfillmentId;

import java.util.UUID;

public interface FulfillmentCommandService {
    UUID handle(CreateFulfillmentCommand command);
}
