package quri.teelab.api.teelab.orderfulfillment.domain.model.commands;

public record CreateFulfillmentCommand(
        String orderId,
        String manufacturerId
) {
}
