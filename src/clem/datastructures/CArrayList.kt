package clem.datastructures

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
     */
    fun add(element: T){
        if(currentIndex >= array.size){
            this.doubleSize()
        }
        array[currentIndex] = element
        currentIndex++
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
     */
    override fun toString(): String{
        var value = "["

        for(i in 0 until currentIndex){
            value += "${array[i]}"
            if(i < currentIndex - 1){
                value += ", "
            }
        }

        value += "]"

        return value
    }
}
