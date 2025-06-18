package quri.teelab.api.teelab.orderfulfillment.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.FulfillmentItemId;
import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.FulfillmentItemStatus;
import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.ProductId;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "fulfillment_items")
public class FulfillmentItem {
    @EmbeddedId
    private FulfillmentItemId id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "product_id", nullable = false))
    private ProductId productId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private FulfillmentItemStatus status;

    public FulfillmentItem(FulfillmentItemId id, ProductId productId, int quantity, FulfillmentItemStatus status) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }

    public void markAsShipped() {
        if (this.status != FulfillmentItemStatus.PENDING) {
            throw new IllegalStateException("Only pending items can be shipped.");
        }
        this.status = FulfillmentItemStatus.SHIPPED;
    }

    public void markAsReceived() {
        if (this.status != FulfillmentItemStatus.SHIPPED) {
            throw new IllegalStateException("Only shipped items can be received.");
        }
        this.status = FulfillmentItemStatus.RECEIVED;
    }
}

