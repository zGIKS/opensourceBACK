package quri.teelab.api.teelab.analytics.application.internal.queryservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;
import quri.teelab.api.teelab.analytics.domain.model.queries.GetCustomerAnalyticsByUserIdQuery;
import quri.teelab.api.teelab.analytics.infrastructure.persistence.jpa.repositories.CustomerAnalyticsRepository;

@Service
public class CustomerAnalyticsQueryServiceImpl {
    private final CustomerAnalyticsRepository customerAnalyticsRepository;

    public CustomerAnalyticsQueryServiceImpl(CustomerAnalyticsRepository customerAnalyticsRepository) {
        this.customerAnalyticsRepository = customerAnalyticsRepository;
    }

    public CustomerAnalytics handle(GetCustomerAnalyticsByUserIdQuery query) {
        return customerAnalyticsRepository.findByUserId(query.getUserId());
    }
}

