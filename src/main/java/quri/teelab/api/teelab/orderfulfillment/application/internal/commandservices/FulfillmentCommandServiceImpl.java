package quri.teelab.api.teelab.orderfulfillment.application.internal.commandservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Fulfillment;
import quri.teelab.api.teelab.orderfulfillment.domain.model.commands.CreateFulfillmentCommand;
import quri.teelab.api.teelab.orderfulfillment.domain.model.valueobjects.FulfillmentId;
import quri.teelab.api.teelab.orderfulfillment.domain.services.FulfillmentCommandService;
import quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence.jpa.repositories.FulfillmentRepository;

import java.util.UUID;

@Service
public class FulfillmentCommandServiceImpl implements FulfillmentCommandService {
    
    private final FulfillmentRepository fulfillmentRepository;
    
    public FulfillmentCommandServiceImpl(FulfillmentRepository fulfillmentRepository) {
        this.fulfillmentRepository = fulfillmentRepository;
    }
      @Override
    public FulfillmentId handle(CreateFulfillmentCommand command) {
        var fulfillment = new Fulfillment(command);
        fulfillmentRepository.save(fulfillment);
        return fulfillment.getId();
    }
}
