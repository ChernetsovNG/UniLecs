package com.unilecs.task102

import java.util.Collections.min

object Task102 {
    // массив мемоизации: индекс - число; значение - наименьшее кол-во операций для приведения его к единице
    private val memoArray = IntArray(10_000_000)

    init {
        memoArray.fill(-1)
        memoArray[0] = 0
        memoArray[1] = 0
        memoArray[2] = 1
        memoArray[3] = 1
    }

    fun getMinOperationsCount(number: Int): Int {
        if (memoArray[number] != -1) {
            return memoArray[number]
        } else {  // заполняем массив мемоизации для всех чисел от 4 до заданного
            var currentNumber = 4
            while (currentNumber <= number) {
                if (memoArray[currentNumber] == -1) {
                    val minOperationsCount = 1 + min(listOf(
                        if (currentNumber % 3 == 0) memoArray[currentNumber / 3] else Int.MAX_VALUE,
                        if (currentNumber % 2 == 0) memoArray[currentNumber / 2] else Int.MAX_VALUE,
                        memoArray[currentNumber - 1]
                    ))
                    memoArray[currentNumber] = minOperationsCount
                }
                currentNumber += 1
            }
        }
        return memoArray[number]
    }
}
