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

        assertEquals(true, result)
    }

    @Test
    fun update_unsuccessful() {
        val newPost = Post()

        val result = WallService.update(newPost)

        assertEquals(false, result)
    }
}