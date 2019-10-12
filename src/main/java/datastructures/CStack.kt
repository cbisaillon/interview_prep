package clem.datastructures

/**
 * Class representing a Stack data structure
 * @author Clement Bisaillon
 * @Date 2019-10-12
 */
class CStack<T> {
    private var array = CArrayList<T>()

    //Get the size of the stack
    val size: Int
        get() = array.size

    /**
     * Add an item to the stack
     * @param item the item to add at the top of the stack
     */
    fun push(item: T){
        array.add(item)
    }

    /**
     * Remove the top item of the stack
     * @return the item that was at the top
     */
    fun pop(): T{
        return array.remove(array.size - 1)
    }

    /**
     * Look at the top of the stack without removing
     * @return the item at the top of the stack
     */
    fun peak(): T{
        return array.get(array.size - 1)
    }
}