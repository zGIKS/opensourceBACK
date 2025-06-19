package quri.teelab.api.teelab.productcatalog.interfaces.rest.transform;

import quri.teelab.api.teelab.productcatalog.domain.model.entities.Comment;
import quri.teelab.api.teelab.productcatalog.interfaces.rest.resources.CommentResource;

public class CommentResourceFromEntityAssembler {

    public static CommentResource toResourceFromEntity(Comment entity) {
        return new CommentResource(
                entity.getId(), // Pasar directamente el UUID en lugar de convertirlo a String
                entity.getUserId().value(),
                entity.getText(),
                entity.getCreatedAt()
        );
    }
}
