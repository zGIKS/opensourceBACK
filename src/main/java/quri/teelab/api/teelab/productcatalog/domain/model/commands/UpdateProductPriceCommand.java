package quri.teelab.api.teelab.productcatalog.domain.model.commands;

import quri.teelab.api.teelab.shared.domain.model.valueobjects.Money;

import java.util.UUID;

public record UpdateProductPriceCommand(
        UUID productId,
        Money price
) {
}
