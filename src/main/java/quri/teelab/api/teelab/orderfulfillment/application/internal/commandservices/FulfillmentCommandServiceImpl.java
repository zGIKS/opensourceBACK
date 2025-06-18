package quri.teelab.api.teelab.orderfulfillment.application.internal.commandservices;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Fulfillment;
import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Manufacturer;
import quri.teelab.api.teelab.orderfulfillment.domain.model.commands.CreateFulfillmentCommand;
import quri.teelab.api.teelab.orderfulfillment.domain.services.FulfillmentCommandService;
import quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence.jpa.repositories.FulfillmentRepository;
import quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence.jpa.repositories.ManufacturerRepository;

import java.util.UUID;

@Service
public class FulfillmentCommandServiceImpl implements FulfillmentCommandService {

    private final FulfillmentRepository fulfillmentRepository;

    public FulfillmentCommandServiceImpl(FulfillmentRepository fulfillmentRepository) {
        this.fulfillmentRepository = fulfillmentRepository;
    }

    @Override
    public UUID handle(CreateFulfillmentCommand command) {
        var fulfillment = new Fulfillment(command);
        fulfillmentRepository.save(fulfillment);
        return fulfillment.getId();
    }
}
