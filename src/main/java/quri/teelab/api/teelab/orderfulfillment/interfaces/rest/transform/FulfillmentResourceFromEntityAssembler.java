package quri.teelab.api.teelab.orderfulfillment.interfaces.rest.transform;

import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Fulfillment;
import quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources.FulfillmentResource;

public class FulfillmentResourceFromEntityAssembler {
      public static FulfillmentResource toResourceFromEntity(Fulfillment entity) {
        return new FulfillmentResource(
                entity.getId().toString(),
                entity.getOrderId().toString(),
                entity.getStatus(),
                entity.getReceivedDate(),
                entity.getShippedDate(),
                entity.getManufacturerId().toString(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
