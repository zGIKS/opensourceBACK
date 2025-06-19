package quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources;

import java.util.Date;

public record ManufacturerResource(
        String id,
        String userId,
        String name,
        String address,
        String city,
        String country,
        String state,
        String zip,
        Date createdAt,
        Date updatedAt
) {
}
