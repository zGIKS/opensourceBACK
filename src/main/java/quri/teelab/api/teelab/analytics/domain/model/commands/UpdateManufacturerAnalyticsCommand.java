package quri.teelab.api.teelab.analytics.domain.model.commands;

import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;

public class UpdateManufacturerAnalyticsCommand {
    private final ManufacturerAnalytics manufacturerAnalytics;

    public UpdateManufacturerAnalyticsCommand(ManufacturerAnalytics manufacturerAnalytics) {
        this.manufacturerAnalytics = manufacturerAnalytics;
    }

    public ManufacturerAnalytics getManufacturerAnalytics() {
        return manufacturerAnalytics;
    }
}

