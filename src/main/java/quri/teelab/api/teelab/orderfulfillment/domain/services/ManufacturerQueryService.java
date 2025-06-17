package quri.teelab.api.teelab.orderfulfillment.domain.services;

import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Manufacturer;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetAllManufacturersQuery;

import java.util.List;

public interface ManufacturerQueryService {
    List<Manufacturer> handle(GetAllManufacturersQuery query);
}
