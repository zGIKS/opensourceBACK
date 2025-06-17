package quri.teelab.api.teelab.analytics.interfaces.rest.resources;

public class ManufacturerAnalyticsResponse {
    private String userId;
    private int totalOrdersReceived;
    private int pendingFulfillments;
    private int producedProjects;
    private double avgFulfillmentTimeDays;

    public ManufacturerAnalyticsResponse(String userId, int totalOrdersReceived, int pendingFulfillments, int producedProjects, double avgFulfillmentTimeDays) {
        this.userId = userId;
        this.totalOrdersReceived = totalOrdersReceived;
        this.pendingFulfillments = pendingFulfillments;
        this.producedProjects = producedProjects;
        this.avgFulfillmentTimeDays = avgFulfillmentTimeDays;
    }

    public String getUserId() { return userId; }
    public int getTotalOrdersReceived() { return totalOrdersReceived; }
    public int getPendingFulfillments() { return pendingFulfillments; }
    public int getProducedProjects() { return producedProjects; }
    public double getAvgFulfillmentTimeDays() { return avgFulfillmentTimeDays; }
}

