package quri.teelab.api.teelab.analytics.infrastructure.persistence.jpa.repositories;

import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;

public interface ManufacturerAnalyticsRepository {
    ManufacturerAnalytics findByUserId(String userId);
}

