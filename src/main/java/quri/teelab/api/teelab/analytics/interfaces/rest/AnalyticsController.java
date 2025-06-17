package quri.teelab.api.teelab.analytics.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quri.teelab.api.teelab.analytics.application.internal.queryservices.AnalyticsCustomerServiceImpl;
import quri.teelab.api.teelab.analytics.application.internal.queryservices.AnalyticsManufacterServiceImpl;
import quri.teelab.api.teelab.analytics.domain.model.queries.GetCustomerAnalyticsByUserIdQuery;
import quri.teelab.api.teelab.analytics.domain.model.queries.GetManufacturerAnalyticsByUserIdQuery;
import quri.teelab.api.teelab.analytics.interfaces.rest.resources.CustomerAnalyticsResponse;
import quri.teelab.api.teelab.analytics.interfaces.rest.resources.ManufacturerAnalyticsResponse;
import quri.teelab.api.teelab.analytics.interfaces.rest.transform.CustomerAnalyticsMapper;
import quri.teelab.api.teelab.analytics.interfaces.rest.transform.ManufacturerAnalyticsMapper;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    private final AnalyticsManufacterServiceImpl manufacturerAnalyticsQueryService;
    private final AnalyticsCustomerServiceImpl customerAnalyticsQueryService;

    public AnalyticsController(AnalyticsManufacterServiceImpl manufacturerAnalyticsQueryService,
                               AnalyticsCustomerServiceImpl customerAnalyticsQueryService) {
        this.manufacturerAnalyticsQueryService = manufacturerAnalyticsQueryService;
        this.customerAnalyticsQueryService = customerAnalyticsQueryService;
    }

    /**
     * Get analytics metrics for a manufacturer by userId.
     *
     * @param userId the manufacturer user identifier
     * @return Manufacturer analytics metrics
     */
    @GetMapping("/manufacturer/{userId}")
    @Operation(
        summary = "Get manufacturer analytics",
        description = "Returns analytics metrics related to production and fulfillment for a manufacturer, such as total orders received, pending fulfillments, produced projects, and average fulfillment time."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Manufacturer analytics found and returned successfully"),
        @ApiResponse(responseCode = "404", description = "Manufacturer analytics not found for the given userId"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ManufacturerAnalyticsResponse> getManufacturerAnalytics(@PathVariable String userId) {
        var query = new GetManufacturerAnalyticsByUserIdQuery(userId);
        var analytics = manufacturerAnalyticsQueryService.handle(query);
        if (analytics == null) {
            return ResponseEntity.notFound().build();
        }
        var response = ManufacturerAnalyticsMapper.toResponse(analytics);
        return ResponseEntity.ok(response);
    }

    /**
     * Get analytics metrics for a customer by userId.
     *
     * @param userId the customer user identifier
     * @return Customer analytics metrics
     */
    @GetMapping("/customer/{userId}")
    @Operation(
        summary = "Get customer analytics",
        description = "Returns analytics metrics related to design activities for a customer, such as total projects, blueprints, designed garments, and completed projects."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Customer analytics found and returned successfully"),
        @ApiResponse(responseCode = "404", description = "Customer analytics not found for the given userId"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<CustomerAnalyticsResponse> getCustomerAnalytics(@PathVariable String userId) {
        var query = new GetCustomerAnalyticsByUserIdQuery(userId);
        var analytics = customerAnalyticsQueryService.handle(query);
        if (analytics == null) {
            return ResponseEntity.notFound().build();
        }
        var response = CustomerAnalyticsMapper.toResponse(analytics);
        return ResponseEntity.ok(response);
    }
}
