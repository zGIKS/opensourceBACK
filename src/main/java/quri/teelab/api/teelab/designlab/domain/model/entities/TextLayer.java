package quri.teelab.api.teelab.designlab.domain.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerType;

@Entity
@DiscriminatorValue("TEXT")
@Getter
public class TextLayer extends Layer {
    @Column(nullable = false)
    private String text;
    private String fontColor;
    private String fontFamily;
    private Integer fontSize;
    private Boolean isBold;
    private Boolean isItalic;
    private Boolean isUnderlined;

    protected TextLayer() {}

    public TextLayer(
        LayerId id, int x, int y, int z, Float opacity, boolean isVisible, LayerType type,
        String text, String fontColor, String fontFamily, Integer fontSize,
        Boolean isBold, Boolean isItalic, Boolean isUnderlined
    ) {
        super(id, x, y, z, opacity, isVisible, type);
        this.text = text;
        this.fontColor = fontColor;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.isBold = isBold;
        this.isItalic = isItalic;
        this.isUnderlined = isUnderlined;
    }
}
