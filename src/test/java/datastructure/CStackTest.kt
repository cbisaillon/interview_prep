package datastructure

import clem.datastructures.CStack
import org.junit.Test
import org.junit.Assert.*

/**
 * Tests for the CStack class
 * @author Clement Bisaillon
 */
class CStackTest {
    @Test
    fun test_add_item(){
        val stack = CStack<Int>()
        stack.push(1)
        assertEquals(1, stack.pop())
    }

    @Test
    fun test_pop(){
        val stack = CStack<Int>()
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
    }
}