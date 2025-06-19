package quri.teelab.api.teelab.designlab.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import quri.teelab.api.teelab.designlab.domain.model.entities.Layer;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.*;

import java.util.*;

@Entity
@Getter
@Table(name = "projects")
public class Project {
    @EmbeddedId
    private ProjectId id;

    @Embedded
    private UserId userId;

    @Embedded
    @Enumerated(EnumType.STRING)
    private GarmentColor garmentColor;

    @Embedded
    @Enumerated(EnumType.STRING)
    private GarmentSize garmentSize;

    @Embedded
    @Enumerated(EnumType.STRING)
    private GarmentGender garmentGender;

    private String title;

    @URL
    private String previewUrl;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @OneToMany(
        cascade = CascadeType.ALL
    )
    @JoinColumn(name = "project_id", referencedColumnName = "projectId")
    private List<Layer> layers = new ArrayList<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // Default constructor required by JPA
    protected Project() {}

    public Project(ProjectId id, UserId userId, String title, String previewUrl, ProjectStatus status, GarmentColor garmentColor, GarmentSize garmentSize, GarmentGender garmentGender) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.previewUrl = previewUrl;
        this.status = status;
        this.layers = new ArrayList<>();
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.garmentColor = garmentColor;
        this.garmentSize = garmentSize;
        this.garmentGender = garmentGender;
    }

    public ProjectId getId() { return id; }
    public UserId getUserId() { return userId; }
    public String getTitle() { return title; }
    public String getPreviewUrl() { return previewUrl; }
    public ProjectStatus getStatus() { return status; }
    public List<Layer> getLayers() { return Collections.unmodifiableList(layers); }
    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public void removeLayer(LayerId layerId) {
        layers.removeIf(layer -> layer.getId().equals(layerId));
    }

    public boolean hasLayerWithId(UUID layerId) {
        var layerIdToCheck = new LayerId(layerId);
        return layers.stream().anyMatch(layer -> layer.getId().equals(layerIdToCheck));
    }

    // ...otros métodos de negocio...
}
