package quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Fulfillment;
import quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence.jpa.repositories.FulfillmentRepository;

import java.text.SimpleDateFormat;

// @Component // DISABLED: Commented out to prevent sample data initialization for persistent data
@Order(1) // Execute first
public class FulfillmentDataInitializer implements CommandLineRunner {
    
    @Autowired
    private FulfillmentRepository fulfillmentRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (fulfillmentRepository.count() == 0) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            
            // Create sample fulfillments based on your provided data
            Fulfillment fulfillment1 = new Fulfillment(
                    "order-1",
                    "delivered",
                    dateFormat.parse("2025-05-29T20:40:47.478Z"),
                    null,
                    "manufacturer-1"
            );
            
            Fulfillment fulfillment2 = new Fulfillment(
                    "order-1",
                    "pending",
                    dateFormat.parse("2025-05-29T20:40:47.478Z"),
                    dateFormat.parse("2025-05-30T20:40:47.478Z"),
                    "manufacturer-1"
            );
            
            Fulfillment fulfillment3 = new Fulfillment(
                    "order-1",
                    "pending",
                    dateFormat.parse("2025-06-16T15:41:38.244Z"),
                    null,
                    "manufacturer-1"
            );
            
            fulfillmentRepository.save(fulfillment1);
            fulfillmentRepository.save(fulfillment2);
            fulfillmentRepository.save(fulfillment3);
            
            System.out.println("Sample fulfillment data initialized successfully!");
        }
    }
}
