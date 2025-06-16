package quri.teelab.api.teelab.designlab.domain.model.aggregates;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import quri.teelab.api.teelab.designlab.domain.model.commands.DeleteProjectLayerCommand;
import quri.teelab.api.teelab.designlab.domain.model.entities.Layer;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectStatus;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.UserId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // Default constructor required by JPA
    public Project() {}
    public Project(DeleteProjectLayerCommand command) {
        this.id = new ProjectId(command.projectId());
    }

    // Business methods
    public boolean hasLayerWithId(UUID layerId) {
        var layerIdToCheck = new LayerId(layerId);
        return layers.stream().anyMatch(layer -> layer.getId().equals(layerIdToCheck));
    }
}
