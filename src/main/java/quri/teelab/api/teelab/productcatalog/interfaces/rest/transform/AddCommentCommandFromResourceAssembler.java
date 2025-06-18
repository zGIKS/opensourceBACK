package quri.teelab.api.teelab.productcatalog.interfaces.rest.transform;

import quri.teelab.api.teelab.productcatalog.domain.model.commands.AddCommentCommand;
import quri.teelab.api.teelab.productcatalog.domain.model.valueobjects.UserId;
import quri.teelab.api.teelab.productcatalog.interfaces.rest.resources.CreateCommentResource;

import java.util.UUID;

public class AddCommentCommandFromResourceAssembler {
    
    public static AddCommentCommand toCommandFromResource(UUID productId, CreateCommentResource resource) {
        return new AddCommentCommand(
                productId,
                UserId.of(resource.userId()),
                resource.text()
        );
    }
}
