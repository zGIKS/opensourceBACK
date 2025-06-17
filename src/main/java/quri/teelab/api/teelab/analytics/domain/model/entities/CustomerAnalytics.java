package quri.teelab.api.teelab.analytics.domain.model.entities;

import quri.teelab.api.teelab.analytics.domain.model.valueobjects.AnalyticsId;

public class CustomerAnalytics {
    private final AnalyticsId id;
    private final String userId;
    private final int totalProjects;
    private final int blueprints;
    private final int designedGarments;
    private final int completed;

    public CustomerAnalytics(AnalyticsId id, String userId, int totalProjects, int blueprints, int designedGarments, int completed) {
        this.id = id;
        this.userId = userId;
        this.totalProjects = totalProjects;
        this.blueprints = blueprints;
        this.designedGarments = designedGarments;
        this.completed = completed;
    }

    public AnalyticsId getId() { return id; }
    public String getUserId() { return userId; }
    public int getTotalProjects() { return totalProjects; }
    public int getBlueprints() { return blueprints; }
    public int getDesignedGarments() { return designedGarments; }
    public int getCompleted() { return completed; }
}
