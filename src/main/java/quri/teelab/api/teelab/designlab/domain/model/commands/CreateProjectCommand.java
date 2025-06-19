package quri.teelab.api.teelab.designlab.domain.model.commands;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.GarmentColor;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.UserId;

public record CreateProjectCommand(UserId userId,
                                   String title,
                                   GarmentColor garmentColor,
                                      String garmentGender,
                                        String garmentSize


) {
    public CreateProjectCommand {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (garmentColor == null) {
            throw new IllegalArgumentException("Garment color cannot be null");
        }
    }

}
