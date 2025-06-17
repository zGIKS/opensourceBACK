package quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources;

import java.util.Date;

public record FulfillmentResource(
        String id,
        String orderId,
        String status,
        Date receivedDate,
        Date shippedDate,
        String manufacturerId,
        Date createdAt,
        Date updatedAt
) {
}
