package quri.teelab.api.teelab.designlab.domain.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerType;

@Entity
@DiscriminatorValue("IMAGE")
@Getter
public class ImageLayer extends Layer {
    @URL
    @Column(nullable = false)
    private String imageUrl;
    private Float width;
    private Float height;

    protected ImageLayer() {}

    public ImageLayer(
            LayerId id, int x, int y, int z, Float opacity, boolean isVisible, LayerType type,
            String imageUrl, Float width, Float height
    ) {
        super(id, x, y, z, opacity, isVisible, type);
        this.imageUrl = imageUrl;
        this.width = width;
        this.height = height;
    }
}
