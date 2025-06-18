package quri.teelab.api.teelab.analytics.domain.model.aggregates;

import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;
import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;

public class User {
    private CustomerAnalytics customerAnalytics;
    private ManufacturerAnalytics manufacturerAnalytics;

    public User(CustomerAnalytics customerAnalytics, ManufacturerAnalytics manufacturerAnalytics) {
        this.customerAnalytics = customerAnalytics;
        this.manufacturerAnalytics = manufacturerAnalytics;
    }

    public CustomerAnalytics getCustomerAnalytics() {
        return customerAnalytics;
    }

    public ManufacturerAnalytics getManufacturerAnalytics() {
        return manufacturerAnalytics;
    }

    public void updateCustomerAnalytics(CustomerAnalytics newAnalytics) {
        this.customerAnalytics = newAnalytics;
    }

    public void updateManufacturerAnalytics(ManufacturerAnalytics newAnalytics) {
        this.manufacturerAnalytics = newAnalytics;
    }
}

