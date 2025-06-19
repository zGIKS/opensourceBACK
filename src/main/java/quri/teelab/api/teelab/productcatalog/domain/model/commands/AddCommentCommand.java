package quri.teelab.api.teelab.productcatalog.domain.model.commands;

import quri.teelab.api.teelab.productcatalog.domain.model.valueobjects.UserId;

import java.util.UUID;

public record AddCommentCommand(
        UUID productId,
        UserId userId,
        String text
) {
    /**
     * Alternative constructor accepting a String userId
     */
    public AddCommentCommand(UUID productId, String userId, String text) {
        this(productId, UserId.of(userId), text);
    }
}
