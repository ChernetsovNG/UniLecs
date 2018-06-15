package com.unilecs.task101

import java.util.*

fun getArrayMajorityElement(array: Array<Int>): Int? {
    val arrayMajorityElementOptional = getArrayMajorityElementOptional(array)
    return if (arrayMajorityElementOptional.isPresent) {
        arrayMajorityElementOptional.get()
    } else {
        println("Мажоритарный элемент отсутствует")
        null
    }
}

private fun getArrayMajorityElementOptional(array: Array<Int>): Optional<Int> {
    val threshold = Math.floor(array.size / 2.0)

    val countMap = getCountMap(array)

    val maybeMajorityElements = countMap.filter { it.value > threshold }.keys

    return if (maybeMajorityElements.size == 1) {
        Optional.of(maybeMajorityElements.first())
    } else {
        Optional.empty()
    }

}

private fun getCountMap(array: Array<Int>): Map<Int, Int> {
    val countMap: MutableMap<Int, Int> = HashMap()
    for (element in array) {
        if (!countMap.containsKey(element)) {
            countMap[element] = 1
        } else {
            val count = countMap[element]!!
            countMap[element] = count + 1
        }
    }
    return countMap
}
