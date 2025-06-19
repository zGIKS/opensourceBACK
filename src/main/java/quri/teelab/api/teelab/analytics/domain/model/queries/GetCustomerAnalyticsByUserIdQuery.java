package quri.teelab.api.teelab.analytics.domain.model.queries;

import java.util.UUID;

public class GetCustomerAnalyticsByUserIdQuery {
    private final UUID userId;

    public GetCustomerAnalyticsByUserIdQuery(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
