package quri.teelab.api.teelab.designlab.domain.model.aggregates;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.URL;
import quri.teelab.api.teelab.designlab.domain.model.entities.Layer;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectStatus;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.UserId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @EmbeddedId
    private ProjectId id;

    private String title;

    @Embedded
    private UserId userId;

    @URL
    private String previewUrl;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private List<Layer> layers = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // Default constructor required by JPA
    public Project() {}

    // Business methods
    public void addLayer(Layer layer) {
        this.layers.add(layer);
    }

    public void removeLayer(Layer layer) {
        this.layers.remove(layer);
    }

}
