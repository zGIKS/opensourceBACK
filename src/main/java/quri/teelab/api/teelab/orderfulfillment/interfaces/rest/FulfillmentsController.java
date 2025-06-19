package quri.teelab.api.teelab.orderfulfillment.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetAllFulfillmentsByManufacturerIdQuery;
import quri.teelab.api.teelab.orderfulfillment.domain.model.queries.GetFulfillmentByIdQuery;
import quri.teelab.api.teelab.orderfulfillment.domain.services.FulfillmentCommandService;
import quri.teelab.api.teelab.orderfulfillment.domain.services.FulfillmentQueryService;
import quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources.CreateFulfillmentResource;
import quri.teelab.api.teelab.orderfulfillment.interfaces.rest.resources.FulfillmentResource;
import quri.teelab.api.teelab.orderfulfillment.interfaces.rest.transform.CreateFulfillmentCommandFromResourceAssembler;
import quri.teelab.api.teelab.orderfulfillment.interfaces.rest.transform.FulfillmentResourceFromEntityAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/fulfillments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Fulfillments", description = "Available Fulfillment Endpoints")
public class FulfillmentsController {

    private final FulfillmentCommandService fulfillmentCommandService;
    private final FulfillmentQueryService fulfillmentQueryService;

    public FulfillmentsController(FulfillmentCommandService fulfillmentCommandService, FulfillmentQueryService fulfillmentQueryService) {
        this.fulfillmentCommandService = fulfillmentCommandService;
        this.fulfillmentQueryService = fulfillmentQueryService;
    }

    @GetMapping(value = "/{manufacturerId}")
    @Operation(summary = "Get all fulfillments", description = "Get all fulfillments")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Fulfillments found"), @ApiResponse(responseCode = "404", description = "Fulfillments not found")})
    public ResponseEntity<List<FulfillmentResource>> getAllFulfillmentsByManufacturerId(@PathVariable String manufacturerId) {

        var getAllFulfillmentsByManufacturerIdQuery = new GetAllFulfillmentsByManufacturerIdQuery(manufacturerId);
        // TODO: Create a transform resource to get manufacturerId from request parameters
        var fulfillments = fulfillmentQueryService.handle(getAllFulfillmentsByManufacturerIdQuery);
        if (fulfillments.isEmpty()) return ResponseEntity.notFound().build();
        var fulfillmentResources = fulfillments.stream().map(FulfillmentResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(fulfillmentResources);
    }

    @PostMapping
    @Operation(summary = "Create fulfillment", description = "Create a new fulfillment with the provided details")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Fulfillment created successfully"), @ApiResponse(responseCode = "400", description = "Invalid input data"), @ApiResponse(responseCode = "404", description = "Fulfillment not found")})
    public ResponseEntity<FulfillmentResource> createFulfillment(@RequestBody CreateFulfillmentResource resource) {
        var createFulfillmentCommand = CreateFulfillmentCommandFromResourceAssembler.toCommandFromResource(resource);
        var fulfillmentId = fulfillmentCommandService.handle(createFulfillmentCommand);
        if (fulfillmentId == null) return ResponseEntity.badRequest().build();

        var getFulfillmentByIdQuery = new GetFulfillmentByIdQuery(fulfillmentId);
        var fulfillment = fulfillmentQueryService.handle(getFulfillmentByIdQuery);
        if (fulfillment.isEmpty()) return ResponseEntity.notFound().build();

        var fulfillmentEntity = fulfillment.get();
        var fulfillmentResource = FulfillmentResourceFromEntityAssembler.toResourceFromEntity(fulfillmentEntity);
        return new ResponseEntity<>(fulfillmentResource, HttpStatus.CREATED);
    }
}
