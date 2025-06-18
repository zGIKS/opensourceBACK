package quri.teelab.api.teelab.shared.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

// TODO: Check if Serializable Interface is needed for JPA
@Embeddable
public record Address(
    @Column(name = "address", nullable = false) String address,
    @Column(name = "city", nullable = false) String city,
    @Column(name = "country", nullable = false) String country,
    @Column(name = "state", nullable = false) String state,
    @Column(name = "zip", nullable = false) String zip
) {
    public Address {
        if (address == null || city == null || country == null || state == null || zip == null) {
            throw new IllegalArgumentException("Address fields cannot be null");
        }
    }
}
