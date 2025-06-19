package quri.teelab.api.teelab.analytics.application.internal.queryservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;
import quri.teelab.api.teelab.analytics.domain.model.queries.GetManufacturerAnalyticsByUserIdQuery;
import quri.teelab.api.teelab.analytics.infrastructure.persistence.jpa.repositories.ManufacturerAnalyticsRepository;

@Service
public class ManufacterAnalyticsQueryServiceImpl {
    private final ManufacturerAnalyticsRepository manufacturerAnalyticsRepository;

    public ManufacterAnalyticsQueryServiceImpl(ManufacturerAnalyticsRepository manufacturerAnalyticsRepository) {
        this.manufacturerAnalyticsRepository = manufacturerAnalyticsRepository;
    }

    public ManufacturerAnalytics handle(GetManufacturerAnalyticsByUserIdQuery query) {
        return manufacturerAnalyticsRepository.findByUserId(query.getUserId());
    }
}
