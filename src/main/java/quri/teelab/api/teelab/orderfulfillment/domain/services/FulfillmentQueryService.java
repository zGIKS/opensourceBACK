package quri.teelab.api.teelab.orderfulfillment.domain.services;

import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Fulfillment;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetAllFulfillmentsQuery;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetFulfillmentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface FulfillmentQueryService {
    List<Fulfillment> handle(GetAllFulfillmentsQuery query);
    Optional<Fulfillment> handle(GetFulfillmentByIdQuery query);
}
