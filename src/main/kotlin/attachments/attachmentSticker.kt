package attachments

import interfaces.Attachment

data class StickerAttachment(
    val sticker: Sticker
) : Attachment {
    override val type: String
        get() = "sticker"
}

data class Sticker(
    val productId: Int,
    val stickerId: Int,
    val images: ArrayList<StickerImages>,
    val imagesWithBackground: ArrayList<StickerImages>,
    val animationUrl: String,
    val isAllowed: Boolean,
)

data class StickerImages(
    val url: String,
    val width: Int,
    val height: Int,
)
