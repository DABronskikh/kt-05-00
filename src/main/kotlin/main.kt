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
)

object WallService {
    private var uid = 0
    private var posts = emptyArray<Post>()

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
