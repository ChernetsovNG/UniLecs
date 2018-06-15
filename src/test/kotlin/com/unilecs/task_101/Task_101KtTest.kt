package com.unilecs.task_101

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class Task_101KtTest {

    @Test
    fun getArrayMajorityElementTest1() {
        val array: Array<Int> = arrayOf(1, 2, 3, 4, 1, 1, 1)
        val majorityElement = getArrayMajorityElement(array)
        assertEquals(1, majorityElement)
    }

    @Test
    fun getArrayMajorityElementTest2() {
        val array: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7)
        val majorityElement = getArrayMajorityElement(array)
        assertNull(majorityElement)
    }

}
