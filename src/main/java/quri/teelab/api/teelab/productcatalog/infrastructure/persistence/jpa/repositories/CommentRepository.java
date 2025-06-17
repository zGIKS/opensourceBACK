package quri.teelab.api.teelab.productcatalog.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quri.teelab.api.teelab.productcatalog.domain.model.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
