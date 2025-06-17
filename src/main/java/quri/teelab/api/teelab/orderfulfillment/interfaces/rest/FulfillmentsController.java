package quri.teelab.api.teelab.orderfulfillment.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetAllFulfillmentsQuery;
import quri.teelab.api.teelab.orderfulfillment.domain.services.FulfillmentQueryService;
import quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources.FulfillmentResource;
import quri.teelab.api.teelab.orderfulfillment.interfaces.rest.transform.FulfillmentResourceFromEntityAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/fulfillments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Fulfillments", description = "Available Fulfillment Endpoints")
public class FulfillmentsController {
    
    private final FulfillmentQueryService fulfillmentQueryService;
    
    public FulfillmentsController(FulfillmentQueryService fulfillmentQueryService) {
        this.fulfillmentQueryService = fulfillmentQueryService;
    }
    
    @GetMapping
    @Operation(summary = "Get all fulfillments", description = "Get all fulfillments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fulfillments found"),
            @ApiResponse(responseCode = "404", description = "Fulfillments not found")
    })
    public ResponseEntity<List<FulfillmentResource>> getAllFulfillments() {
        var fulfillments = fulfillmentQueryService.handle(new GetAllFulfillmentsQuery());
        if (fulfillments.isEmpty()) return ResponseEntity.notFound().build();
        var fulfillmentResources = fulfillments.stream()
                .map(FulfillmentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(fulfillmentResources);
    }
}
