package quri.teelab.api.teelab.designlab.model.entities;

import lombok.Getter;
import org.hibernate.validator.constraints.URL;

public class ImageLayer extends Layer {
    @Getter
    @URL
    private String imageUrl;

    @Getter
    private Float width;

    @Getter
    private Float height;
}
