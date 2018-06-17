package com.unilecs.task102

import com.unilecs.task102.Task102.getMinOperationsCount
import org.junit.Test

import org.junit.Assert.*

class Task102Test {

    @Test
    fun getMinOperationsCountTest1() {
        val minOperationsCount = getMinOperationsCount(9)
        assertEquals(2, minOperationsCount)
    }

    @Test
    fun getMinOperationsCountTest2() {
        val minOperationsCount = getMinOperationsCount(11)
        assertEquals(4, minOperationsCount)
    }

    @Test
    fun getMinOperationsCountTest3() {
        assertEquals(0, getMinOperationsCount(1))
        assertEquals(1, getMinOperationsCount(2))
        assertEquals(1, getMinOperationsCount(3))
    }

    @Test
    fun bigNumberTest() {
        assertEquals(19, getMinOperationsCount(1_000_000))
        assertEquals(21, getMinOperationsCount(9_999_999))
    }
}
