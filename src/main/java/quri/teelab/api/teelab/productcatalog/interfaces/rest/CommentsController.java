package quri.teelab.api.teelab.productcatalog.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quri.teelab.api.teelab.productcatalog.domain.model.queries.GetProductByIdQuery;
import quri.teelab.api.teelab.productcatalog.domain.services.ProductCommandService;
import quri.teelab.api.teelab.productcatalog.domain.services.ProductQueryService;
import quri.teelab.api.teelab.productcatalog.interfaces.rest.resources.CommentResource;
import quri.teelab.api.teelab.productcatalog.interfaces.rest.resources.CreateCommentResource;
import quri.teelab.api.teelab.productcatalog.interfaces.rest.transform.AddCommentCommandFromResourceAssembler;
import quri.teelab.api.teelab.productcatalog.interfaces.rest.transform.CommentResourceFromEntityAssembler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/products/{productId}/comments", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Comments", description = "Available Comment Endpoints")
public class CommentsController {
    
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;
    
    public CommentsController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }
    
    @PostMapping
    @Operation(summary = "Add comment to product", description = "Add a new comment to a specific product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Comment added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity<CommentResource> addComment(
            @PathVariable Long productId,
            @RequestBody CreateCommentResource resource) {
        
        var product = productQueryService.handle(new GetProductByIdQuery(productId));
        if (product.isEmpty()) return ResponseEntity.notFound().build();
        
        var addCommentCommand = AddCommentCommandFromResourceAssembler.toCommandFromResource(productId, resource);
        var commentId = productCommandService.handle(addCommentCommand);
        
        if (commentId == null || commentId == 0L) return ResponseEntity.badRequest().build();
        
        // Get the updated product
        var updatedProduct = productQueryService.handle(new GetProductByIdQuery(productId));
        if (updatedProduct.isEmpty()) return ResponseEntity.notFound().build();
        
        // Find the newly added comment
        var comment = updatedProduct.get().getComments().stream()
                .filter(c -> c.getId().equals(commentId))
                .findFirst();
        
        if (comment.isEmpty()) return ResponseEntity.notFound().build();
        
        var commentResource = CommentResourceFromEntityAssembler.toResourceFromEntity(comment.get());
        return new ResponseEntity<>(commentResource, HttpStatus.CREATED);
    }
}
