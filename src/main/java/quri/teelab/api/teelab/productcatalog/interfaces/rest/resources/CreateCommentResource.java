package quri.teelab.api.teelab.productcatalog.interfaces.rest.resources;

public record CreateCommentResource(
        String userId,
        String text
) {
}
