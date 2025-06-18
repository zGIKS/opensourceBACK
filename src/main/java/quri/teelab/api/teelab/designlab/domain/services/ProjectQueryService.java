package quri.teelab.api.teelab.designlab.domain.services;

import quri.teelab.api.teelab.designlab.domain.model.aggregates.Project;
import quri.teelab.api.teelab.designlab.domain.model.queries.GetAllProjectsByUserIdQuery;

import java.util.List;

public interface ProjectQueryService {

    List<Project> handle(GetAllProjectsByUserIdQuery query);
}
