package quri.teelab.api.teelab.orderfulfillment.application.internal.queryservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Fulfillment;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetAllFulfillmentsQuery;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetFulfillmentByIdQuery;
import quri.teelab.api.teelab.orderfulfillment.domain.services.FulfillmentQueryService;
import quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence.jpa.repositories.FulfillmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FulfillmentQueryServiceImpl implements FulfillmentQueryService {
    
    private final FulfillmentRepository fulfillmentRepository;
    
    public FulfillmentQueryServiceImpl(FulfillmentRepository fulfillmentRepository) {
        this.fulfillmentRepository = fulfillmentRepository;
    }
    
    @Override
    public List<Fulfillment> handle(GetAllFulfillmentsQuery query) {
        return fulfillmentRepository.findAll();
    }
    
    @Override
    public Optional<Fulfillment> handle(GetFulfillmentByIdQuery query) {
        return fulfillmentRepository.findById(query.fulfillmentId());
    }
}
