package quri.teelab.api.teelab.analytics.domain.model.entities;

import quri.teelab.api.teelab.analytics.domain.model.valueobjects.AnalyticsId;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customer_analytics")
public class CustomerAnalytics {
    @EmbeddedId
    private AnalyticsId id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "total_projects")
    private int totalProjects;

    @Column(name = "blueprints")
    private int blueprints;

    @Column(name = "designed_garments")
    private int designedGarments;

    @Column(name = "completed")
    private int completed;

    // Constructor sin argumentos requerido por JPA
    protected CustomerAnalytics() {}

    public CustomerAnalytics(AnalyticsId id, UUID userId, int totalProjects, int blueprints, int designedGarments, int completed) {
        this.id = id;
        this.userId = userId;
        this.totalProjects = totalProjects;
        this.blueprints = blueprints;
        this.designedGarments = designedGarments;
        this.completed = completed;
    }

    public AnalyticsId getId() { return id; }
    public UUID getUserId() { return userId; }
    public int getTotalProjects() { return totalProjects; }
    public int getBlueprints() { return blueprints; }
    public int getDesignedGarments() { return designedGarments; }
    public int getCompleted() { return completed; }
}
