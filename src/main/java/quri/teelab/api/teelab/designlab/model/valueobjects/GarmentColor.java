package quri.teelab.api.teelab.designlab.model.valueobjects;

public enum GarmentColor {

    BLACK ("#161615"),
    GRAY ("#403D3B"),
    LIGHT_GRAY ("#B3B1AF"),
    WHITE ("#EDEDED"),
    RED ("#B51B14"),
    PINK ("#F459B0"),
    LIGHT_PURPLE ("#D890E4"),
    PURPLE ("#693FA0"),
    LIGHT_BLUE ("#00A5BC"),
    CYAN ("#31B7C9"),
    SKY_BLUE ("#3F9BDC"),
    BLUE ("#1B3D92"),
    GREEN ("#1B8937"),
    LIGHT_GREEN ("#5BBE65"),
    YELLOW ("#FECD08"),
    DARK_YELLOW ("#F2AB00");

    private final String value;

    GarmentColor(String value) {
        this.value = value;
    }

    public String getDisplayName() {
        return value;
    }
}
