package quri.teelab.api.teelab.analytics.domain.model.aggregates;

import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;

public class CustomerAnalyticsAggregate {
    private CustomerAnalytics customerAnalytics;

    public CustomerAnalyticsAggregate(CustomerAnalytics customerAnalytics) {
        this.customerAnalytics = customerAnalytics;
    }

    public CustomerAnalytics getCustomerAnalytics() {
        return customerAnalytics;
    }

    public void updateAnalytics(CustomerAnalytics newAnalytics) {
        this.customerAnalytics = newAnalytics;
    }
}

