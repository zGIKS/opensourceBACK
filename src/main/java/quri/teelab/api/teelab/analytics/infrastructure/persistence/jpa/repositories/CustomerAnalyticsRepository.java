package quri.teelab.api.teelab.analytics.infrastructure.persistence.jpa.repositories;

import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;

public interface CustomerAnalyticsRepository {
    CustomerAnalytics findByUserId(String userId);
}

