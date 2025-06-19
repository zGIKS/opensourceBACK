package quri.teelab.api.teelab.orderfulfillment.domain.model.commands;

import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.ManufacturerId;
import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.OrderId;

public record CreateFulfillmentCommand(
        OrderId orderId,
        ManufacturerId manufacturerId
) {
}
