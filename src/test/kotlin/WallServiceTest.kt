import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val newPost = Post()

        val result = WallService.add(newPost)

        assertNotEquals(0, result.id)
    }

    @Test
    fun update_successful() {
        val newPost = WallService.add(Post())

        val result = WallService.update(newPost.copy(text = "text update"))

        assertTrue(result)
    }

    @Test
    fun update_unsuccessful() {
        val newPost = Post()

        val result = WallService.update(newPost)

        assertFalse(result)
    }


    @Test
    fun createComment_successful() {
        val newPost = WallService.add(Post())
        val newComment = Comment(id = 1)

        val result = WallService.createComment(newPost.id, newComment)

        assertNotEquals(0, result.id)
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_unsuccessful() {
        WallService.add(Post())
        val newComment = Comment()

        WallService.createComment(0, newComment)
    }


}