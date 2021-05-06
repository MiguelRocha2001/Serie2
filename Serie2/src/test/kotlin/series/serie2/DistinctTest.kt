package series.serie2

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import series.serie2.ListUtilTest.emptyListWithSentinelNonCircular
import series.serie2.ListUtilTest.getSize
import series.serie2.ListUtilTest.isEmptyListWithSentinelNonCircular
import series.serie2.ListUtilTest.isListSortedAndDistinct
import series.serie2.ListUtilTest.makeDListNonCircular
import kotlin.test.assertEquals

class DistinctTest {
    @Test
    fun distinct_empty_list() {
        val list = emptyListWithSentinelNonCircular<Int>()
        val returnList = distinct(list, CMP_NATURAL_ORDER)
        assertTrue(isEmptyListWithSentinelNonCircular(list))
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER))
        assertEquals(0, getSize(returnList))
    }

    @Test
    fun distinct_with_oneElement_list() {
        val list: Node<Int> = makeDListNonCircular(10)
        val returnList = distinct(list, CMP_NATURAL_ORDER)
        assertTrue(isEmptyListWithSentinelNonCircular(list))
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER))
        assertEquals(1, getSize(returnList))
    }

    @Test
    fun distinct_with_SomeElements1_list() {
        val mutableList = mutableListOf<Int>()
        mutableList.add(4)
        mutableList.add(3)
        mutableList.add(2)
        mutableList.add(1)
        val list: Node<Int> = makeDListNonCircular(*mutableList.toTypedArray())
        val returnList = distinct(list, CMP_REVERSE_ORDER)
        assertTrue(isEmptyListWithSentinelNonCircular(list))
        assertTrue(isListSortedAndDistinct(returnList, CMP_REVERSE_ORDER))
        assertEquals(4, getSize(returnList))
    }

    @Test
    fun distinct_with_SomeElements2_list() {
        val mutableList = mutableListOf<Int>()
        mutableList.add(4)
        mutableList.add(4)
        mutableList.add(4)
        mutableList.add(3)
        mutableList.add(2)
        mutableList.add(2)
        mutableList.add(1)
        val list: Node<Int> = makeDListNonCircular(*mutableList.toTypedArray())
        val returnList = distinct(list, CMP_REVERSE_ORDER)
        assertTrue(isEmptyListWithSentinelNonCircular(list))
        assertTrue(isListSortedAndDistinct(returnList, CMP_REVERSE_ORDER))
        assertEquals(4, getSize(returnList))
    }

    @Test
    fun distinct_with_SomeElements3_list() {
        val mutableList = mutableListOf<Int>()
        mutableList.add(1)
        mutableList.add(1)
        mutableList.add(1)
        mutableList.add(2)
        mutableList.add(2)
        mutableList.add(2)
        mutableList.add(2)
        mutableList.add(2)
        val list: Node<Int> = makeDListNonCircular(*mutableList.toTypedArray())
        val returnList = distinct(list, CMP_NATURAL_ORDER)
        assertTrue(isEmptyListWithSentinelNonCircular(list))
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER))

        assertEquals(2, getSize(returnList))
    }

    @Test
    fun distinct_with_SomeElements4_list() {
        val mutableList = mutableListOf<Int>()
        mutableList.add(1)
        mutableList.add(2)
        mutableList.add(2)
        mutableList.add(2)
        mutableList.add(2)
        mutableList.add(2)
        val list: Node<Int> = makeDListNonCircular(*mutableList.toTypedArray())
        val returnList = distinct(list, CMP_NATURAL_ORDER)
        assertTrue(isEmptyListWithSentinelNonCircular(list))
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER))

        assertEquals(2, getSize(returnList))
    }

    @Test
    fun distinct_with_SomeElements5_list() {
        val mutableList = mutableListOf<Int>()
        mutableList.add(-10)
        mutableList.add(-1)
        mutableList.add(-1)
        mutableList.add(2)
        mutableList.add(2)
        mutableList.add(20)
        mutableList.add(20)
        val list: Node<Int> = makeDListNonCircular(*mutableList.toTypedArray())
        val returnList = distinct(list, CMP_NATURAL_ORDER)
        assertTrue(isEmptyListWithSentinelNonCircular(list))
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER))

        assertEquals(4, getSize(returnList))
    }

    companion object {
        val CMP_REVERSE_ORDER = Comparator { i1: Int?, i2: Int ->
            i2.compareTo(
                i1!!
            )
        }
        val CMP_NATURAL_ORDER = Comparator { i1: Int, i2: Int? ->
            i1.compareTo(
                i2!!
            )
        }
    }
}






