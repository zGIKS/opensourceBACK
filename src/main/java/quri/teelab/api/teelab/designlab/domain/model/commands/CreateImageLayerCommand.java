package quri.teelab.api.teelab.designlab.domain.model.commands;

public record CreateImageLayerCommand
        (String projectId, String imageUrl, Float width, Float height)
{
}
