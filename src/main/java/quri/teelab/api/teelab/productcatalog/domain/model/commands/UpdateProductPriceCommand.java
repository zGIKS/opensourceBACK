package quri.teelab.api.teelab.productcatalog.domain.model.commands;

import quri.teelab.api.teelab.productcatalog.domain.model.valueobjects.Money;

public record UpdateProductPriceCommand(
        Long productId,
        Money price
) {
}
