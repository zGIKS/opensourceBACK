package quri.teelab.api.teelab.analytics.interfaces.rest.resources;

public class CustomerAnalyticsResource {
    private String userId;
    private int totalProjects;
    private int blueprints;
    private int designedGarments;
    private int completed;
    private String id;

    public CustomerAnalyticsResource(String userId, int totalProjects, int blueprints, int designedGarments, int completed, String id) {
        this.userId = userId;
        this.totalProjects = totalProjects;
        this.blueprints = blueprints;
        this.designedGarments = designedGarments;
        this.completed = completed;
        this.id = id;
    }

    public String getUserId() { return userId; }
    public int getTotalProjects() { return totalProjects; }
    public int getBlueprints() { return blueprints; }
    public int getDesignedGarments() { return designedGarments; }
    public int getCompleted() { return completed; }
    public String getId() { return id; }
}

