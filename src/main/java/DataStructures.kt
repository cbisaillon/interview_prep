package clem

import clem.datastructures.CArrayList

/**
 * Entry point of data structures I developped
 * @Author: Clement Bisaillon
 * @Date: 2019-10-11
 */
fun main(){
    val list = CArrayList<Int>()

    list.add(1)
    list.add(2)
    list.add(6)

    println(list.toString())
    println("Size: ${list.size}")
}
