package quri.teelab.api.teelab.productcatalog.interfaces.rest.transform;

import quri.teelab.api.teelab.productcatalog.domain.model.entities.Comment;
import quri.teelab.api.teelab.productcatalog.interfaces.rest.resources.CommentResource;

public class CommentResourceFromEntityAssembler {
    
    public static CommentResource toResourceFromEntity(Comment entity) {
        return new CommentResource(
                entity.getId().toString(),
                entity.getUserId().value(), // Extract the string value from the UserId object
                entity.getText(),
                entity.getCreatedAt()
        );
    }
}
