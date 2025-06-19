package quri.teelab.api.teelab.designlab.domain.services;

import quri.teelab.api.teelab.designlab.domain.model.commands.CreateProjectCommand;
import quri.teelab.api.teelab.designlab.domain.model.commands.DeleteProjectLayerCommand;

import java.util.UUID;

public interface ProjectCommandService {
    UUID handle(DeleteProjectLayerCommand command);
    UUID handle(CreateProjectCommand command);
}
