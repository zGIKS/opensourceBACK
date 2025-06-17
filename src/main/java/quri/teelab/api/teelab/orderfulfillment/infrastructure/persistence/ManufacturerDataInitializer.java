package quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Manufacturer;
import quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence.jpa.repositories.ManufacturerRepository;

// @Component // DISABLED: Commented out to prevent sample data initialization for persistent data
@Order(2) // Execute after FulfillmentDataInitializer
public class ManufacturerDataInitializer implements CommandLineRunner {
    
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (manufacturerRepository.count() == 0) {
            // Create sample manufacturer based on your provided data
            Manufacturer manufacturer1 = new Manufacturer(
                    "user-2",
                    "Manufacturer One",
                    "123 Main St",
                    "Anytown",
                    "USA",
                    "CA",
                    "12345"
            );
            
            manufacturerRepository.save(manufacturer1);
            
            System.out.println("Sample manufacturer data initialized successfully!");
        }
    }
}
