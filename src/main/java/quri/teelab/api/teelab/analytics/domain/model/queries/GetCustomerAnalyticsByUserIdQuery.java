package quri.teelab.api.teelab.analytics.domain.model.queries;

public class GetCustomerAnalyticsByUserIdQuery {
    private final String userId;

    public GetCustomerAnalyticsByUserIdQuery(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}

