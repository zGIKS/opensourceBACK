package quri.teelab.api.teelab.productcatalog.interfaces.rest.transform;

import quri.teelab.api.teelab.productcatalog.domain.model.commands.AddCommentCommand;
import quri.teelab.api.teelab.productcatalog.domain.model.valueobjects.UserId;
import quri.teelab.api.teelab.productcatalog.interfaces.rest.resources.CreateCommentResource;

public class AddCommentCommandFromResourceAssembler {
    
    public static AddCommentCommand toCommandFromResource(Long productId, CreateCommentResource resource) {
        return new AddCommentCommand(
                productId,
                UserId.of(resource.userId()),
                resource.text()
        );
    }
}
