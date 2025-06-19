package quri.teelab.api.teelab.analytics.domain.model.queries;

import java.util.UUID;

public class GetManufacturerAnalyticsByUserIdQuery {
    private final UUID userId;

    public GetManufacturerAnalyticsByUserIdQuery(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
