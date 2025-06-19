package quri.teelab.api.teelab.analytics.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;

import java.util.UUID;

@Repository
public interface CustomerAnalyticsRepository extends JpaRepository<CustomerAnalytics, Long> {
    CustomerAnalytics findByUserId(UUID userId);
}
