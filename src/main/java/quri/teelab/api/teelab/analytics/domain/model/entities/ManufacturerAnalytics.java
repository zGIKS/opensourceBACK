package quri.teelab.api.teelab.analytics.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;
import quri.teelab.api.teelab.analytics.domain.model.valueobjects.AnalyticsId;

import java.util.UUID;

@Entity
public class ManufacturerAnalytics {
    @EmbeddedId
    private AnalyticsId id;
    private UUID userId;
    private int totalOrdersReceived;
    private int pendingFulfillments;
    private int producedProjects;
    private double avgFulfillmentTimeDays;

    // Constructor sin argumentos requerido por JPA
    protected ManufacturerAnalytics() {}

    public ManufacturerAnalytics(AnalyticsId id, UUID userId, int totalOrdersReceived, int pendingFulfillments, int producedProjects, double avgFulfillmentTimeDays) {
        this.id = id;
        this.userId = userId;
        this.totalOrdersReceived = totalOrdersReceived;
        this.pendingFulfillments = pendingFulfillments;
        this.producedProjects = producedProjects;
        this.avgFulfillmentTimeDays = avgFulfillmentTimeDays;
    }

    public AnalyticsId getId() { return id; }
    public UUID getUserId() { return userId; }
    public int getTotalOrdersReceived() { return totalOrdersReceived; }
    public int getPendingFulfillments() { return pendingFulfillments; }
    public int getProducedProjects() { return producedProjects; }
    public double getAvgFulfillmentTimeDays() { return avgFulfillmentTimeDays; }
}
