package quri.teelab.api.teelab.analytics.interfaces.rest.transform;

import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;
import quri.teelab.api.teelab.analytics.interfaces.rest.resources.ManufacturerAnalyticsResource;

public class ManufacturerAnalyticsResourceFromEntityAssembler {
    public static ManufacturerAnalyticsResource toResponse(ManufacturerAnalytics analytics) {
        return new ManufacturerAnalyticsResource(
                analytics.getUserId().toString(),
                analytics.getTotalOrdersReceived(),
                analytics.getPendingFulfillments(),
                analytics.getProducedProjects(),
                analytics.getAvgFulfillmentTimeDays()
        );
    }
}
