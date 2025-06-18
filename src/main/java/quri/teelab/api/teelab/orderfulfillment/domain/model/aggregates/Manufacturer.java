package quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.ManufacturerId;
import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.UserId;
import quri.teelab.api.teelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import quri.teelab.api.teelab.shared.domain.model.valueobjects.Address;

import java.util.UUID;

@Getter
@Entity
@Table(name = "manufacturers")
public class Manufacturer extends AuditableAbstractAggregateRoot<Manufacturer> {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private ManufacturerId id;

    @Embedded
    @Column(name = "user_id", nullable = false)
    private UserId userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private Address address;

    public Manufacturer() {
        // Default constructor for JPA
    }

    public Manufacturer(String userId, String name, String address, String city, String country, String state, String zip) {
        this.userId = new UserId(UUID.fromString(userId));
        this.name = name;
        this.address = new Address(address, city, country, state, zip);
    }

    public void updateInformation(String name, String address, String city, String country, String state, String zip) {
        this.name = name;
        this.address = new Address(address, city, country, state, zip);
    }
}
