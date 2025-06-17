package quri.teelab.api.teelab.productcatalog.domain.model.queries;

import java.util.List;

public record SearchProductsByTagsQuery(
        List<String> tags
) {
}