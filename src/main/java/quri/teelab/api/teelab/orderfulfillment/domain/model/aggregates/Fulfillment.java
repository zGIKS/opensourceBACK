package quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import quri.teelab.api.teelab.orderfulfillment.domain.model.commands.CreateFulfillmentCommand;
import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.FulfillmentStatus;
import quri.teelab.api.teelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;

@Getter
@Entity
@Table(name = "fulfillments")
public class Fulfillment extends AuditableAbstractAggregateRoot<Fulfillment> {
      @Column(name = "order_id", nullable = false)
    private String orderId;
      @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private FulfillmentStatus status;
    
    @Column(name = "received_date", nullable = true)
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
      public Fulfillment(String orderId, FulfillmentStatus status, Date receivedDate, Date shippedDate, String manufacturerId) {
        this.orderId = orderId;
        this.status = status;
        this.receivedDate = receivedDate;
        this.shippedDate = shippedDate;
        this.manufacturerId = manufacturerId;
    }    // Constructor for creating new fulfillments (status is "PENDING", receivedDate and shippedDate are null by default)
    public Fulfillment(CreateFulfillmentCommand command) {
        this.orderId = command.orderId();
        this.status = FulfillmentStatus.PENDING; // Automatically set to "PENDING" for new fulfillments
        this.receivedDate = null; // Automatically set to null for new fulfillments (not yet received by manufacturer)
        this.shippedDate = null; // Automatically set to null for new fulfillments
        this.manufacturerId = command.manufacturerId();
    }    public void updateStatus(FulfillmentStatus status) {
        this.status = status;
    }
    
    public void updateReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }
    
    public void updateShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }
}
