package quri.teelab.api.teelab.designlab.interfaces.rest.transform;

import quri.teelab.api.teelab.designlab.domain.model.aggregates.Project;
import quri.teelab.api.teelab.designlab.interfaces.rest.resources.ProjectResource;

public class ProjectResourceFromEntityAssembler {

    public static ProjectResource toResourceFromEntity(Project entity) {
        return new ProjectResource(
            entity.getId().projectId(),
            entity.getTitle(),
            entity.getUserId().userId(),
            entity.getCreatedAt().toString(),
            entity.getUpdatedAt().toString()
        );
    }
}
