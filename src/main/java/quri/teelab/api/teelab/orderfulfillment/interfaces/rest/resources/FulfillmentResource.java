package quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources;

import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.FulfillmentStatus;

import java.util.Date;

public record FulfillmentResource(
        String id,
        String orderId,
        FulfillmentStatus status,
        Date receivedDate,
        Date shippedDate,
        String manufacturerId,
        Date createdAt,
        Date updatedAt
) {
}
