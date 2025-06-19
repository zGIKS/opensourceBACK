package quri.teelab.api.teelab.analytics.domain.model.commands;

import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;

public class UpdateCustomerAnalyticsCommand {
    private final CustomerAnalytics customerAnalytics;

    public UpdateCustomerAnalyticsCommand(CustomerAnalytics customerAnalytics) {
        this.customerAnalytics = customerAnalytics;
    }

    public CustomerAnalytics getCustomerAnalytics() {
        return customerAnalytics;
    }
}

