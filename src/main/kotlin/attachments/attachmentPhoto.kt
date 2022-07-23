package attachments

import interfaces.Attachment

data class PhotoAttachment(
    val photo: Photo
) : Attachment {
    override val type: String
        get() = "photo"
}

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userid: Int,
    val text: String,
    val date: Int,
    val sizes: ArrayList<PhotoSizes>,
    val width: Int?,
    val height: Int?,
)

data class PhotoSizes(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int,
)