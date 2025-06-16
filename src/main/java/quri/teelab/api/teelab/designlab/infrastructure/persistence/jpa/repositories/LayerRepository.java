package quri.teelab.api.teelab.designlab.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quri.teelab.api.teelab.designlab.domain.model.entities.Layer;

import java.util.UUID;

@Repository
public interface LayerRepository extends JpaRepository<Layer, UUID> {
}
