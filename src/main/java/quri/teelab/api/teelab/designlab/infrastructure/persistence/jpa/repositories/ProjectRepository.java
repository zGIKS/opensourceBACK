package quri.teelab.api.teelab.designlab.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quri.teelab.api.teelab.designlab.domain.model.aggregates.Project;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.ProjectId;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {
    boolean existsById(UUID projectId);
    boolean existsByUserId(UUID userId);
    List<Project> findAllByUserId(UUID userId);
}
