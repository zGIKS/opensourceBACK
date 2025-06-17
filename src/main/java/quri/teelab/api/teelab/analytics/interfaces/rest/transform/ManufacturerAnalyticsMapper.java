package quri.teelab.api.teelab.analytics.interfaces.rest.transform;

import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;
import quri.teelab.api.teelab.analytics.interfaces.rest.resources.ManufacturerAnalyticsResponse;

public class ManufacturerAnalyticsMapper {
    public static ManufacturerAnalyticsResponse toResponse(ManufacturerAnalytics analytics) {
        return new ManufacturerAnalyticsResponse(
            analytics.getUserId(),
            analytics.getTotalOrdersReceived(),
            analytics.getPendingFulfillments(),
            analytics.getProducedProjects(),
            analytics.getAvgFulfillmentTimeDays()
        );
    }
}

