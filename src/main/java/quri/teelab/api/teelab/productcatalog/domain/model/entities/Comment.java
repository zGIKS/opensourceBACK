package quri.teelab.api.teelab.productcatalog.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import quri.teelab.api.teelab.productcatalog.domain.model.valueobjects.UserId;
import quri.teelab.api.teelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
@Table(name = "comments")
public class Comment extends AuditableAbstractAggregateRoot<Comment> {
    
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_id", nullable = false))
    private UserId userId;
    
    @Column(name = "text", nullable = false, length = 1000)
    private String text;
      public Comment() {
        // Default constructor for JPA
    }
    
    public Comment(UserId userId, String text) {
        this.userId = userId;
        this.text = text;
    }
    
    public Comment(String userId, String text) {
        this(UserId.of(userId), text);
    }
    
    public void updateText(String text) {
        this.text = text;
    }
}
