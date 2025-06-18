package quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record OrderId(UUID orderId) {
}
