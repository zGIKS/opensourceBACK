package quri.teelab.api.teelab.productcatalog.domain.model.commands;

import quri.teelab.api.teelab.productcatalog.domain.model.valueobjects.UserId;

public record AddCommentCommand(
        Long productId,
        UserId userId,
        String text
) {
    /**
     * Alternative constructor accepting a String userId
     */
    public AddCommentCommand(Long productId, String userId, String text) {
        this(productId, UserId.of(userId), text);
    }
}
