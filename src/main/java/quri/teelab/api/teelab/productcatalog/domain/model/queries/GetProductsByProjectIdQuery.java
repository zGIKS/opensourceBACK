package quri.teelab.api.teelab.productcatalog.domain.model.queries;

import quri.teelab.api.teelab.productcatalog.domain.model.valueobjects.ProjectId;

public record GetProductsByProjectIdQuery(
        ProjectId projectId
) {
    /**
     * Alternative constructor accepting a String projectId
     */
    public GetProductsByProjectIdQuery(String projectId) {
        this(ProjectId.of(projectId));
    }
}
