package clem.datastructures

/**
 * Class representinf a Queue data structure
 * @author Clement Bisaillon
 */
class CQueue<T> {
    private var list = arrayOfNulls<Any?>(1)
    private var front = 0
    private var back = 0

    //Get the site of the queue
    val size: Int
        get() = front - back

    /**
     * Enqueue an item in the queue
     */
    fun enqueue(item : T){
        if(front >= size){
            doubleSize()
        }

        list[front++] = item
    }

    @Suppress("UNCHECKED_CAST")
    fun dequeue(): T{
        if(back == front){
            throw IllegalAccessError()
        }

        return list[back++] as T
    }

    /**
     * Doubles the size of the array
     */
    private fun doubleSize() {
        val backup = list
        list = arrayOfNulls<Any?>(list.size * 2)

        //Copy the values
        for (i in 0 until backup.size) {
            list[i] = backup[i]
        }
    }
}