package quri.teelab.api.teelab.designlab.domain.model.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

@Entity
@DiscriminatorValue("IMAGE")
@Getter
public class ImageLayer extends Layer {
    @Getter
    @URL
    private String imageUrl;

    @Getter
    private Float width;

    @Getter
    private Float height;
}
