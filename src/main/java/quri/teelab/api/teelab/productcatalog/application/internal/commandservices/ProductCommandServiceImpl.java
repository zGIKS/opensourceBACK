package quri.teelab.api.teelab.productcatalog.application.internal.commandservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.productcatalog.domain.model.aggregates.Product;
import quri.teelab.api.teelab.productcatalog.domain.model.commands.AddCommentCommand;
import quri.teelab.api.teelab.productcatalog.domain.model.commands.CreateProductCommand;
import quri.teelab.api.teelab.productcatalog.domain.model.commands.UpdateProductPriceCommand;
import quri.teelab.api.teelab.productcatalog.domain.model.entities.Comment;
import quri.teelab.api.teelab.productcatalog.domain.services.ProductCommandService;
import quri.teelab.api.teelab.productcatalog.infrastructure.persistence.jpa.repositories.CommentRepository;
import quri.teelab.api.teelab.productcatalog.infrastructure.persistence.jpa.repositories.ProductRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    
    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;
    
    public ProductCommandServiceImpl(ProductRepository productRepository, CommentRepository commentRepository) {
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
    }
    
    @Override
    public UUID handle(CreateProductCommand command) {
        var product = new Product(command);
        productRepository.save(product);
        return product.getId();
    }
    
    @Override
    public void handle(UpdateProductPriceCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.productId());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.updatePrice(command.price());
            productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Product not found with ID: " + command.productId());
        }
    }
    
    @Override
    public UUID handle(AddCommentCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.productId());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            Comment comment = new Comment(command.userId(), command.text());
            commentRepository.save(comment);
            
            product.addComment(comment);
            productRepository.save(product);
            
            return comment.getId();
        } else {
            throw new IllegalArgumentException("Product not found with ID: " + command.productId());
        }
    }
}
