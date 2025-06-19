package quri.teelab.api.teelab.designlab.domain.services;

import quri.teelab.api.teelab.designlab.domain.model.commands.CreateImageLayerCommand;
import quri.teelab.api.teelab.designlab.domain.model.commands.CreateTextLayerCommand;
import quri.teelab.api.teelab.designlab.domain.model.valueobjects.LayerId;

public interface LayerCommandService {

    LayerId handle(CreateTextLayerCommand command);

    LayerId handle(CreateImageLayerCommand command);
}
