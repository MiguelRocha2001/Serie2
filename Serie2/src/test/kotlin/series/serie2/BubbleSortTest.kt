package series.serie2

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import series.serie2.ListUtilTest.emptySListWithSentinel
import series.serie2.ListUtilTest.getRandomSList
import series.serie2.ListUtilTest.getSListWithSentinel
import series.serie2.ListUtilTest.isSListSorted

class BubbleSortTest {
    @Test
    fun bubblesort_empty_list() {
        val list = emptySListWithSentinel<Int>()
        bubbleSort(list, CMP_NATURAL_ORDER)
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER))
    }

    @Test
    fun bubblesort_with_oneElement_list() {
        val list: Node<Int> = getRandomSList(1)
        bubbleSort(list, CMP_NATURAL_ORDER)
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER))
    }

    @Test
    fun bubblesort_with_SomeElements1_list() {
        val array = ArrayList<Int>()
        array.add(4)
        array.add(3)
        array.add(2)
        array.add(1)
        val list = getSListWithSentinel(array)
        bubbleSort(list, CMP_NATURAL_ORDER)
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER))
    }


    @Test
    fun bubblesort_with_increasingElements() {
        val list = getSListWithSentinel(0, 20, 1)
        bubbleSort(list, CMP_REVERSE_ORDER)
        assertTrue(isSListSorted(list, CMP_REVERSE_ORDER))
    }

    @Test
    fun bubblesort_with_SomeElements2_list() {
        val array = ArrayList<Int>()
        array.add(22)
        array.add(-30)
        array.add(-30)
        array.add(32)
        array.add(-38)
        array.add(-34)
        array.add(-36)
        val list = getSListWithSentinel(array)
        bubbleSort(list, CMP_NATURAL_ORDER)
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER))
    }

    @Test
    fun bubblesort_with_someElements3_list() {
        val array = ArrayList<Int>()
        array.add(27)
        array.add(-12)
        array.add(33)
        array.add(27)
        array.add(26)
        array.add(-33)
        array.add(14)
        array.add(26)
        array.add(8)
        array.add(9)
        array.add(-19)
        val list = getSListWithSentinel(array)
        bubbleSort(list, CMP_NATURAL_ORDER)
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER))
    }

    @Test
    fun bubblesort_with_randomElements_list() {
        val list: Node<Int> = getRandomSList(11)
        bubbleSort(list, CMP_NATURAL_ORDER)
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER))
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






