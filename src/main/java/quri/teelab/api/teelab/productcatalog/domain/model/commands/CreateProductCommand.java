package quri.teelab.api.teelab.productcatalog.domain.model.commands;

import java.util.List;

import quri.teelab.api.teelab.productcatalog.domain.model.valueobjects.ManufacturerId;
import quri.teelab.api.teelab.shared.domain.model.valueobjects.Money;
import quri.teelab.api.teelab.productcatalog.domain.model.valueobjects.ProjectId;

public record CreateProductCommand(
        ProjectId projectId,
        ManufacturerId manufacturerId,
        Money price,
        List<String> tags,
        List<String> gallery,
        String status
) {
    /**
     * Alternative constructor accepting String IDs
     */
    public CreateProductCommand(
            String projectId,
            String manufacturerId,
            Money price,
            List<String> tags,
            List<String> gallery,
            String status
    ) {
        this(
                ProjectId.of(projectId),
                ManufacturerId.of(manufacturerId),
                price,
                tags,
                gallery,
                status
        );
    }
}
