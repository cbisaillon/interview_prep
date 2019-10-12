package clem.datastructures

import java.lang.IndexOutOfBoundsException
import java.lang.StringBuilder

/**
 * Represents an ArrayList data structure
 * @Author: Clement Bisaillon
 * @Date: 2019-10-12
 */
class CArrayList<T>(){
    private var array = arrayOfNulls<Any?>(1)
    private var currentIndex = 0

    //Returns the size of the array (excluding empty items)
    val size: Int
        get() = currentIndex

    /**
     * Add an element to the array. If the array is full, double
     * its size.
     * @param element the element of add
     */
    fun add(element: T){
        if(currentIndex >= array.size){
            this.doubleSize()
        }
        array[currentIndex] = element
        currentIndex++
    }

    /**
     * Get the element at the specified index
     * @param index the index to get the item from
     * @return the item retrieved at index
     */
    @Suppress("UNCHECKED_CAST")
    fun get(index: Int): T{
        if(index > currentIndex - 1){
            throw IndexOutOfBoundsException()
        }

        return array[index] as T
    }

    /**
     * Removes the element at a certain index
     * @param index the index to remove from the array
     * @return the item removed
     */
    @Suppress("UNCHECKED_CAST")
    fun remove(index: Int): T{
        if(index > currentIndex - 1){
            throw IndexOutOfBoundsException()
        }
        val newArray = arrayOfNulls<Any?>(array.size - 1)
        val deletedItem = array[index]
        var pointer = 0

        //Copy each element except for index to delete
        for(i in 0 until newArray.size){
            if(i == index) {
                pointer++
            }

            newArray[i] = array[pointer]
            pointer++
        }

        currentIndex--
        array = newArray

        return deletedItem as T
    }

    /**
     * Search the array for an item and removes it
     * @param item the item to remove
     */
    fun removeItem(item: T){
        val newArray = arrayOfNulls<Any?>(array.size - 1)
        var pointer = 0

        for(i in 0 until newArray.size){
            if(array[i]?.equals(item) == true){
                pointer++
            }

            newArray[i] = array[pointer]
            pointer++
        }

        currentIndex--
        array = newArray
    }

    /**
     * Clears the array
     */
    fun clear(){
        array = arrayOfNulls<Any?>(1)
        currentIndex = 0
    }

    /**
     * Doubles the size of the array by recreating a new
     * one and copying all the elements
     */
    private fun doubleSize(){
        //Double the array size
        val backup = array
        array = arrayOfNulls<Any?>(array.size * 2)

        //copy each elements
        for(i in 0 until backup.size){
            array[i] = backup[i]
        }
    }

    /**
     * Displays the array in a readable way
     * @return the string representation of the arraylist
     */
    override fun toString(): String{
        val valueBuilder = StringBuilder("[")

        for(i in 0 until currentIndex){
            valueBuilder.append("${array[i]}")
            if(i < currentIndex - 1){
                valueBuilder.append(", ")
            }
        }

        valueBuilder.append("]")

        return valueBuilder.toString()
    }
}
