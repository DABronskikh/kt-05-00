package attachments

import interfaces.Attachment

data class DocAttachment(
    val doc: Doc
) : Attachment {
    override val type: String
        get() = "doc"
}

data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val type: Int,
)
