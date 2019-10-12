package datastructure

import clem.datastructures.CArrayList
import org.junit.Test
import org.junit.Assert.*
import java.lang.IndexOutOfBoundsException


/**
 * Tests the CArrayList class
 * @author Clement Bisaillon
 */
class CArrayListTest {

    @Test
    fun test_can_add_items(){
        val list = CArrayList<Int>()
        list.add(15)
        assertEquals(15, list.get(0))
    }

    @Test
    fun test_can_get_items(){
        val list = CArrayList<Int>()
        list.add(3)
        list.add(7)
        assertEquals(3, list.get(0))
        assertEquals(7, list.get(1))
    }

    @Test
    fun test_remove_item(){
        val list = CArrayList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.remove(1)

        assertEquals(2, list.size)
        assertEquals(3, list.get(1))
    }

    @Test
    fun test_remove_specific_item(){
        val list = CArrayList<Int>()
        list.add(3)
        list.add(5)
        list.add(98)
        list.removeItem(5)

        assertEquals(2, list.size)
        assertEquals(98, list.get(1))
    }

    @Test
    fun test_can_clear(){
        val list = CArrayList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.clear()

        assertEquals(0, list.size)
    }

    @Test
    fun test_error_on_out_of_bounds(){
        val list = CArrayList<Int>()
        var outOfBound = false
        try{
            list.get(999)
        }catch (exception: IndexOutOfBoundsException){
            outOfBound = true
        }

        assert(outOfBound)
    }

    @Test
    fun test_error_on_out_of_bounds_added(){
        val list = CArrayList<Int>()
        list.add(1) //size = 1
        list.add(2) //size = 2
        list.add(3) //size = 4
        list.add(4) //size = 4
        list.add(5) //size = 8

        //check if can access index 7
        var outOfBound = false
        try{
            list.get(7)
        }catch(exception: IndexOutOfBoundsException){
            outOfBound = true
        }

        assert(outOfBound)
    }

    @Test
    fun test_size_increases_of_add(){
        val list = CArrayList<Int>()
        assertEquals(0, list.size)

        list.add(1)
        assertEquals(1, list.size)
    }
}