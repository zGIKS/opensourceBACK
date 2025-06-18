package quri.teelab.api.teelab.orderfulfillment.domain.model.queries;

import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.ManufacturerId;

import java.util.UUID;

public record GetAllFulfillmentsByManufacturerIdQuery(ManufacturerId manufacturerId) {
}
