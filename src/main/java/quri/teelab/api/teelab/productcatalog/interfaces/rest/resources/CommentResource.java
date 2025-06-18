package quri.teelab.api.teelab.productcatalog.interfaces.rest.resources;

import java.util.Date;
import java.util.UUID;

public record CommentResource(
        UUID id,
        String userId,
        String text,
        Date createdAt
) {
    // Constructor sin parámetros necesario para la serialización/deserialización
    public CommentResource() {
        this(null, null, null, null);
    }

    // Constructor para crear un nuevo recurso con los valores básicos
    public CommentResource(UUID id, String userId, String text) {
        this(id, userId, text, new Date());
    }
}
