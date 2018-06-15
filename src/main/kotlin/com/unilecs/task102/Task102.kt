package com.unilecs.task102

import java.util.Collections.min

// карта мемоизации вида <число -> наименьшее кол-во операций для приведения его к единице>
private val memoMap: MutableMap<Int, Int> = mutableMapOf(Pair(1, 0), Pair(2, 1), Pair(3, 1))

fun getMinOperationsCount(number: Int): Int {
    return if (number in memoMap) {
        memoMap[number]!!
    } else {
        val minOperationsCount = 1 + min(listOf(
                getMinOperationsCount(number - 1),
                if (number % 2 == 0) getMinOperationsCount(number / 2) else Int.MAX_VALUE,
                if (number % 3 == 0) getMinOperationsCount(number / 3) else Int.MAX_VALUE))
        memoMap[number] = minOperationsCount
        minOperationsCount
    }
}
