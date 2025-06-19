package quri.teelab.api.teelab.productcatalog.domain.model.queries;

import java.util.UUID;

public record GetProductByIdQuery(
        UUID productId
) {
}
