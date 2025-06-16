package quri.teelab.api.teelab.designlab.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;
import quri.teelab.api.teelab.designlab.model.entities.Layer;
import quri.teelab.api.teelab.designlab.model.valueobjects.ProjectId;
import quri.teelab.api.teelab.designlab.model.valueobjects.UserId;

import java.util.List;

@Getter
@Entity
public class Project {
    @Id
    @Getter
    private ProjectId id;

    @Getter
    private String title;

    @Getter
    @Embedded
    private UserId userId;

    @Getter
    @URL
    private String previewUrl;

    private List<Layer> layers;

}
