package quri.teelab.api.teelab.designlab.model.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("TEXT")
@Getter
public class TextLayer extends Layer {
    private String text;
    private String fontColor;
    private String fontFamily;

    private Integer fontSize;
    private Boolean isBold;
    private Boolean isItalic;
    private Boolean isUnderlined;

}
