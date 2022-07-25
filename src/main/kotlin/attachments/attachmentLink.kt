package attachments

import interfaces.Attachment

data class LinkAttachment(
    val link: Link
) : Attachment {
    override val type: String
        get() = "link"
}

data class Link(
    val id: Int,
    val title: String,
    val caption: String,
    val description: String,
    val photo: Photo?,
    val previewPage: String,
    val previewUrl: String,
)
