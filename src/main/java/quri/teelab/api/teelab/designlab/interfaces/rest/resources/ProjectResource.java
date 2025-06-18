package quri.teelab.api.teelab.designlab.interfaces.rest.resources;

import java.util.UUID;

public record ProjectResource(UUID id, String title, UUID userId,
                              String createdAt, String updatedAt
) {

    public ProjectResource {
        if (id == null || title == null || userId == null) {
            throw new IllegalArgumentException("ProjectResource fields cannot be null");
        }
    }
}
