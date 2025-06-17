package quri.teelab.api.teelab.orderfulfillment.interfaces.rest.transform;

import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Manufacturer;
import quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources.ManufacturerResource;

public class ManufacturerResourceFromEntityAssembler {
    
    public static ManufacturerResource toResourceFromEntity(Manufacturer entity) {
        return new ManufacturerResource(
                "manufacturer-" + entity.getId(),
                entity.getUserId(),
                entity.getName(),
                entity.getAddress(),
                entity.getCity(),
                entity.getCountry(),
                entity.getState(),
                entity.getZip(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
