package quri.teelab.api.teelab.designlab.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import quri.teelab.api.teelab.designlab.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.model.valueobjects.LayerType;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "layer_type", discriminatorType = DiscriminatorType.STRING)
@Getter
public class Layer {
    @EmbeddedId
    private LayerId id;

    private int x;
    private int y;
    private int z;

    private Float opacity;
    private boolean isVisible;

    @Enumerated(EnumType.STRING)
    private LayerType type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
