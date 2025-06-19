package quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects;

/**
 * Value object representing the status of a fulfillment.
 * Defines the possible states a fulfillment can be in throughout its lifecycle.
 */
public enum FulfillmentStatus {
    /**
     * Initial status when a fulfillment is created.
     * The fulfillment has been registered but not yet processed.
     */
    PENDING,

    /**
     * The fulfillment is currently being processed by the manufacturer.
     */
    PROCESSING,

    /**
     * The fulfillment has been shipped to the customer.
     */
    SHIPPED,

    /**
     * The fulfillment has been successfully delivered to the customer.
     */
    DELIVERED,

    /**
     * The fulfillment has been cancelled and will not be completed.
     */
    CANCELLED
}
