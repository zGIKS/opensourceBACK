package quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources;

public record CreateFulfillmentResource(
        String orderId,
        String manufacturerId
) {
}
