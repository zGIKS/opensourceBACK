package quri.teelab.api.teelab.designlab.interfaces.rest.resources;

public record CreateProjectResource(
        String title,
        String userId,
        String garmentColor,
        String garmentGender,
        String garmentSize
) {
}
