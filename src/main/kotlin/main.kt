import interfaces.Attachment

fun main() {
}

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = true,
    val comments: PostComments = PostComments(),
    val copyright: PostCopyright = PostCopyright(),
    val likes: PostLikes = PostLikes(),
    val reposts: PostReposts = PostReposts(),
    val views: PostViews = PostViews(),
    val postType: String = "",
    val signerId: Int = 0,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = true,
    val markedAsAds: Boolean = true,
    val isFavorite: Boolean = true,
    val postponedId: Int = 0,
    val postSource: PostSource? = null,
    val geo: PostGeo? = null,
    val copyHistory: ArrayList<Any>? = null,
    val attachments: ArrayList<Attachment>? = null,
)

data class Comment(
    val id: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
)

object WallService {
    private var uid = 0
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    private fun getUid(): Int {
        return ++uid
    }

    fun add(post: Post): Post {
        val newPost = post.copy(id = getUid())
        posts += newPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var result = false
        for ((index, itemPost) in posts.withIndex()) {
            if (itemPost.id == post.id) {
                posts[index] = posts[index].copy(
                    fromId = post.fromId,
                    date = post.date,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    copyright = post.copyright,
                    likes = post.likes,
                    reposts = post.reposts,
                    views = post.views,
                    postType = post.postType,
                    signerId = post.signerId,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    postponedId = post.postponedId,
                )
                result = true
            }
        }

        return result
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        val post = posts.find { postItem -> postItem.id == postId }
        if (post === null) throw PostNotFoundException("no post with id: $postId")

        comments += comment
        return comments.last()
    }
}

data class PostComments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true,
)

data class PostCopyright(
    val id: Int = 0,
    val link: String = "",
    val name: String = "",
    val type: String = "",
)

data class PostLikes(
    val count: Int = 0,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true,
)

data class PostReposts(
    val count: Int = 0,
    val userReposted: Boolean = true,
)

data class PostViews(
    val count: Int = 0,
)

data class PostSource(
    val type: String = "",
    val platform: String = "",
    val data: String = "",
    val url: String = "",
)

data class PostGeo(
    val type: String = "",
    val coordinates: String = "",
    val place: PostGeoPlace? = null,
)

data class PostGeoPlace(
    val id: Int = 0,
    val title: String = "",
    val latitude: Int = 0,
    val longitude: Int = 0,
    val created: Int = 0,
    val icon: String = "",
    val checkins: Int = 0,
    val updated: Int = 0,
    val type: Int = 0,
    val country: Int = 0,
    val city: Int = 0,
    val address: String = "",
)

class PostNotFoundException(message: String) : RuntimeException(message)