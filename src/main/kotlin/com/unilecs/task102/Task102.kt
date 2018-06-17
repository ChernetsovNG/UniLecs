package com.unilecs.task102

import java.util.Collections.min

// карта мемоизации вида <число -> наименьшее кол-во операций для приведения его к единице>
private val memoMap: MutableMap<Int, Int> = mutableMapOf(
    Pair(1, 0),
    Pair(2, 1),
    Pair(3, 1))

fun getMinOperationsCount(number: Int): Int {
    if (number in memoMap) {
        return memoMap[number]!!
    } else {  // заполняем карту мемоизации для всех чисел от 4 до заданного
        var currentNumber = 4
        while (currentNumber <= number) {
            if (!memoMap.containsKey(currentNumber)) {
                val minOperationsCount = 1 + min(listOf(
                    if (currentNumber % 3 == 0) getMinOperationsCount(currentNumber / 3) else Int.MAX_VALUE,
                    if (currentNumber % 2 == 0) getMinOperationsCount(currentNumber / 2) else Int.MAX_VALUE,
                    getMinOperationsCount(currentNumber - 1)
                ))
                memoMap[currentNumber] = minOperationsCount
            }
            currentNumber += 1
        }
    }
    return memoMap[number]!!
}
