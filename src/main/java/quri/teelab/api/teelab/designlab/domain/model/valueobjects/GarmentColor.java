package quri.teelab.api.teelab.designlab.domain.model.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum GarmentColor {
    BLACK,
    GRAY,
    LIGHT_GRAY,
    WHITE,
    RED,
    PINK,
    LIGHT_PURPLE,
    PURPLE,
    LIGHT_BLUE,
    CYAN,
    SKY_BLUE,
    BLUE,
    GREEN,
    LIGHT_GREEN,
    YELLOW,
    DARK_YELLOW;

    @JsonCreator
    public static GarmentColor from(String value) {
        return GarmentColor.valueOf(value.toUpperCase());
    }
}