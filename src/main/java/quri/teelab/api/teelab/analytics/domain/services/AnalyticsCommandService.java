package quri.teelab.api.teelab.analytics.domain.services;

import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;
import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;

/**
 * Query Service for analytics domain logic.
 * Handles read-only business operations for analytics.
 */
public class AnalyticsCommandService {
    /**
     * Calculates the fulfillment rate for a manufacturer.
     *
     * @param analytics ManufacturerAnalytics entity
     * @return fulfillment rate as a double between 0 and 1
     */
    public double calculateFulfillmentRate(ManufacturerAnalytics analytics) {
        int totalOrders = analytics.getTotalOrdersReceived();
        int pending = analytics.getPendingFulfillments();
        if (totalOrders == 0) return 0.0;
        return (double) (totalOrders - pending) / totalOrders;
    }

    /**
     * Calculates the completion rate for a customer.
     *
     * @param analytics CustomerAnalytics entity
     * @return completion rate as a double between 0 and 1
     */
    public double calculateCompletionRate(CustomerAnalytics analytics) {
        int total = analytics.getTotalProjects();
        int completed = analytics.getCompleted();
        if (total == 0) return 0.0;
        return (double) completed / total;
    }
}
