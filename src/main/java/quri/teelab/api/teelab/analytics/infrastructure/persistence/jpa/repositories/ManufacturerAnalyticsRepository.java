package quri.teelab.api.teelab.analytics.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;

import java.util.UUID;

@Repository
public interface ManufacturerAnalyticsRepository extends JpaRepository<ManufacturerAnalytics, Long> {
    ManufacturerAnalytics findByUserId(UUID userId);
}
