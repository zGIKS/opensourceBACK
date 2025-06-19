package quri.teelab.api.teelab.designlab.domain.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import quri.teelab.api.teelab.designlab.domain.model.commands.CreateTextLayerCommand;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerType;

import java.util.UUID;

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

    protected TextLayer() {
    }

    public TextLayer(LayerId id, LayerType type, String text, String fontColor, String fontFamily, Integer fontSize, Boolean isBold, Boolean isItalic, Boolean isUnderlined) {
        super(id, type);
        this.text = text;
        this.fontColor = fontColor;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.isBold = isBold;
        this.isItalic = isItalic;
        this.isUnderlined = isUnderlined;
    }

    public TextLayer(CreateTextLayerCommand command) {
        super(new LayerId(UUID.randomUUID()), LayerType.TEXT);
        this.text = command.text();
        this.fontColor = command.fontColor();
        this.fontFamily = command.fontFamily();
        this.fontSize = command.fontSize();
        this.isBold = command.isBold();
        this.isItalic = command.isItalic();
        this.isUnderlined = command.isUnderlined();
    }


}
