package datastructure

import clem.datastructures.CQueue
import org.junit.Test
import org.junit.Assert.*
import java.lang.Exception

/**
 * Tests for the Queue data structure
 * @author Clement Bisaillon
 */
class CQueueTest {
    @Test
    fun test_enqueue_item(){
        val queue = CQueue<Int>()

        queue.enqueue(1)
        queue.enqueue(2)

        assertEquals(1, queue.dequeue())
        assertEquals(2, queue.dequeue())
    }

    @Test
    fun test_add_pop_add_pop(){
        val queue = CQueue<Int>()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.dequeue()
        queue.enqueue(3)
        queue.dequeue()
        queue.enqueue(4)

        assertEquals(3, queue.dequeue())
    }

    @Test
    fun test_cannot_dequeue_if_empty(){
        val queue = CQueue<Int>()
        queue.enqueue(1)

        var error = false
        try{
            queue.dequeue()
            queue.dequeue()
        }catch (e: IllegalAccessError){
            error = true
        }

        assert(error)
    }
}