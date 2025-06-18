package quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects;

import java.util.UUID;

public record FulfillmentId(UUID fulfillmentId) {
    public FulfillmentId {
        if (fulfillmentId == null) {
            throw new IllegalArgumentException("Fulfillment ID cannot be null");
        }
    }
}
