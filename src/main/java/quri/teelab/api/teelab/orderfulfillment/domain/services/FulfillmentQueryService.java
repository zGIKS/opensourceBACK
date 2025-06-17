package quri.teelab.api.teelab.orderfulfillment.domain.services;

import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Fulfillment;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetAllFulfillmentsQuery;

import java.util.List;

public interface FulfillmentQueryService {
    List<Fulfillment> handle(GetAllFulfillmentsQuery query);
}
