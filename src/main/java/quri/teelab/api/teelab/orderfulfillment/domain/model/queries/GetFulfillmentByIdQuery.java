package quri.teelab.api.teelab.orderfulfillment.domain.model.queries;

import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.FulfillmentId;

public record GetFulfillmentByIdQuery(FulfillmentId fulfillmentId) {
}
