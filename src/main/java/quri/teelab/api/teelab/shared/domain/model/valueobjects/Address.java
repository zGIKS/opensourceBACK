package quri.teelab.api.teelab.shared.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record Address(
        @Column(name = "address_line", nullable = false, length = 200) String address,
        @Column(name = "city", nullable = false, length = 100) String city,
        @Column(name = "country", nullable = false, length = 100) String country,
        @Column(name = "state", nullable = false, length = 100) String state,
        @Column(name = "zip_code", nullable = false, length = 20) String zip
) implements Serializable {
    public Address {
        if (address == null || city == null || country == null || state == null || zip == null) {
            throw new IllegalArgumentException("Address fields cannot be null");
        }
    }
}
