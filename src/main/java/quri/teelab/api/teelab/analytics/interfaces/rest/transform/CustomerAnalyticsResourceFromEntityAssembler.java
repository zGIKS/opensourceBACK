package quri.teelab.api.teelab.analytics.interfaces.rest.transform;

import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;
import quri.teelab.api.teelab.analytics.interfaces.rest.resources.CustomerAnalyticsResource;

public class CustomerAnalyticsResourceFromEntityAssembler {
    public static CustomerAnalyticsResource toResponse(CustomerAnalytics analytics) {
        return new CustomerAnalyticsResource(
            analytics.getUserId(),
            analytics.getTotalProjects(),
            analytics.getBlueprints(),
            analytics.getDesignedGarments(),
            analytics.getCompleted(),
            analytics.getId().getValue()
        );
    }
}
