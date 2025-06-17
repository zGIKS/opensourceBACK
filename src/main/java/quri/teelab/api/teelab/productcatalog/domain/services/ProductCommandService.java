package quri.teelab.api.teelab.productcatalog.domain.services;

import quri.teelab.api.teelab.productcatalog.domain.model.commands.AddCommentCommand;
import quri.teelab.api.teelab.productcatalog.domain.model.commands.CreateProductCommand;
import quri.teelab.api.teelab.productcatalog.domain.model.commands.UpdateProductPriceCommand;

public interface ProductCommandService {
    Long handle(CreateProductCommand command);
    void handle(UpdateProductPriceCommand command);
    Long handle(AddCommentCommand command);
}
