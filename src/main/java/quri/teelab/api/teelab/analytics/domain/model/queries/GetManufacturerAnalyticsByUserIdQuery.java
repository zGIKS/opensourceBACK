package quri.teelab.api.teelab.analytics.domain.model.queries;

public class GetManufacturerAnalyticsByUserIdQuery {
    private final String userId;

    public GetManufacturerAnalyticsByUserIdQuery(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}

