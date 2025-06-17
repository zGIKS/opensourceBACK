package quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import quri.teelab.api.teelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;

@Getter
@Entity
@Table(name = "fulfillments")
public class Fulfillment extends AuditableAbstractAggregateRoot<Fulfillment> {
    
    @Column(name = "order_id", nullable = false)
    private String orderId;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "received_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedDate;
    
    @Column(name = "shipped_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippedDate;
    
    @Column(name = "manufacturer_id", nullable = false)
    private String manufacturerId;
    
    public Fulfillment() {
        // Default constructor for JPA
    }
    
    public Fulfillment(String orderId, String status, Date receivedDate, Date shippedDate, String manufacturerId) {
        this.orderId = orderId;
        this.status = status;
        this.receivedDate = receivedDate;
        this.shippedDate = shippedDate;
        this.manufacturerId = manufacturerId;
    }
    
    public void updateStatus(String status) {
        this.status = status;
    }
    
    public void updateShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }
}
