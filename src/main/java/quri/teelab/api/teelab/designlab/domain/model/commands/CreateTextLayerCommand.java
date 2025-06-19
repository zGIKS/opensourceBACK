package quri.teelab.api.teelab.designlab.domain.model.commands;

import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;

public record CreateTextLayerCommand
        (ProjectId projectId, String text, String fontColor, String fontFamily, Integer fontSize, Boolean isBold, Boolean isItalic, Boolean isUnderlined)

{
    public CreateTextLayerCommand {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text cannot be null or blank");
        }
        if (fontColor == null || fontColor.isBlank()) {
            throw new IllegalArgumentException("Font color cannot be null or blank");
        }
        if (fontFamily == null || fontFamily.isBlank()) {
            throw new IllegalArgumentException("Font family cannot be null or blank");
        }
        if (fontSize == null || fontSize <= 0) {
            throw new IllegalArgumentException("Font size must be a positive number");
        }
    }
}
