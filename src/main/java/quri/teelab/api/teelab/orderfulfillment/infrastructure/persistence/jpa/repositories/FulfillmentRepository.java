package quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Fulfillment;

import java.util.UUID;

@Repository
public interface FulfillmentRepository extends JpaRepository<Fulfillment, UUID> {
}
