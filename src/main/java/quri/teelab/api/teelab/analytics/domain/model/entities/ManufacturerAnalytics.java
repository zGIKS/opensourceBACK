package quri.teelab.api.teelab.analytics.domain.model.entities;

import quri.teelab.api.teelab.analytics.domain.model.valueobjects.AnalyticsId;

public class ManufacturerAnalytics {
    private final AnalyticsId id;
    private final String userId;
    private final int totalOrdersReceived;
    private final int pendingFulfillments;
    private final int producedProjects;
    private final double avgFulfillmentTimeDays;

    public ManufacturerAnalytics(AnalyticsId id, String userId, int totalOrdersReceived, int pendingFulfillments, int producedProjects, double avgFulfillmentTimeDays) {
        this.id = id;
        this.userId = userId;
        this.totalOrdersReceived = totalOrdersReceived;
        this.pendingFulfillments = pendingFulfillments;
        this.producedProjects = producedProjects;
        this.avgFulfillmentTimeDays = avgFulfillmentTimeDays;
    }

    public AnalyticsId getId() { return id; }
    public String getUserId() { return userId; }
    public int getTotalOrdersReceived() { return totalOrdersReceived; }
    public int getPendingFulfillments() { return pendingFulfillments; }
    public int getProducedProjects() { return producedProjects; }
    public double getAvgFulfillmentTimeDays() { return avgFulfillmentTimeDays; }
}
