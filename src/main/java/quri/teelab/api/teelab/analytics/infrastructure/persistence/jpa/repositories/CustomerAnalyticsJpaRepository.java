package quri.teelab.api.teelab.analytics.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;

@Repository
public interface CustomerAnalyticsJpaRepository extends JpaRepository<CustomerAnalytics, String> {
    CustomerAnalytics findByUserId(String userId);
}
