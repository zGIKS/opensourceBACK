package quri.teelab.api.teelab.productcatalog.interfaces.rest.resources;

import java.util.Date;

public record CommentResource(
        String id,
        String userId,
        String text,
        Date createdAt
) {
}
