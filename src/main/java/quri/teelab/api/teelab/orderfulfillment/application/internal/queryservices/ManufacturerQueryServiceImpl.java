package quri.teelab.api.teelab.orderfulfillment.application.internal.queryservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.orderfulfillment.domain.model.aggregates.Manufacturer;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetAllManufacturersQuery;
import quri.teelab.api.teelab.orderfulfillment.domain.services.ManufacturerQueryService;
import quri.teelab.api.teelab.orderfulfillment.infrastructure.persistence.jpa.repositories.ManufacturerRepository;

import java.util.List;

@Service
public class ManufacturerQueryServiceImpl implements ManufacturerQueryService {
    
    private final ManufacturerRepository manufacturerRepository;
    
    public ManufacturerQueryServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }
    
    @Override
    public List<Manufacturer> handle(GetAllManufacturersQuery query) {
        return manufacturerRepository.findAll();
    }
}
