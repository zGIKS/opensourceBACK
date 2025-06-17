package quri.teelab.api.teelab.analytics.domain.model.aggregates;

import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;

public class ManufacturerAnalyticsAggregate {
    private ManufacturerAnalytics manufacturerAnalytics;

    public ManufacturerAnalyticsAggregate(ManufacturerAnalytics manufacturerAnalytics) {
        this.manufacturerAnalytics = manufacturerAnalytics;
    }

    public ManufacturerAnalytics getManufacturerAnalytics() {
        return manufacturerAnalytics;
    }

    public void updateAnalytics(ManufacturerAnalytics newAnalytics) {
        this.manufacturerAnalytics = newAnalytics;
    }
}

