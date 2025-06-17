package quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import quri.teelab.api.teelab.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
@Table(name = "manufacturers")
public class Manufacturer extends AuditableAbstractAggregateRoot<Manufacturer> {
    
    @Column(name = "user_id", nullable = false)
    private String userId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "country", nullable = false)
    private String country;
    
    @Column(name = "state", nullable = false)
    private String state;
    
    @Column(name = "zip", nullable = false)
    private String zip;
    
    public Manufacturer() {
        // Default constructor for JPA
    }
    
    public Manufacturer(String userId, String name, String address, String city, String country, String state, String zip) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zip = zip;
    }
    
    public void updateInformation(String name, String address, String city, String country, String state, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zip = zip;
    }
}
