package quri.teelab.api.teelab.analytics.interfaces.rest.transform;

import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;
import quri.teelab.api.teelab.analytics.interfaces.rest.resources.CustomerAnalyticsResponse;

public class CustomerAnalyticsMapper {
    public static CustomerAnalyticsResponse toResponse(CustomerAnalytics analytics) {
        return new CustomerAnalyticsResponse(
            analytics.getUserId(),
            analytics.getTotalProjects(),
            analytics.getBlueprints(),
            analytics.getDesignedGarments(),
            analytics.getCompleted(),
            analytics.getId().getValue()
        );
    }
}
