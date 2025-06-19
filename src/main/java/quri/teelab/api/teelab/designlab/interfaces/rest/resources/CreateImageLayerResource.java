package quri.teelab.api.teelab.designlab.interfaces.rest.resources;

public record CreateImageLayerResource
        (String projectId, String imageUrl, Float width, Float height)
{

    public CreateImageLayerResource {
        if (imageUrl == null || imageUrl.isBlank()) {
            throw new IllegalArgumentException("Image URL cannot be null or blank");
        }
        if (width == null || width <= 0) {
            throw new IllegalArgumentException("Width must be a positive number");
        }
        if (height == null || height <= 0) {
            throw new IllegalArgumentException("Height must be a positive number");
        }
    }
}
