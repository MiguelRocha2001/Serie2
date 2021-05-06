package series.serie2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import series.serie2.ListUtilTest.emptyListWithSentinel
import series.serie2.ListUtilTest.getListWithSentinel
import series.serie2.ListUtilTest.getRandomListWithSentinel

class GetMiddleTest {
    @Test
    fun middle_empty_list() {
        val list = emptyListWithSentinel<Int>()
        assertEquals(list, getMiddle(list))
    }

    @Test
    fun middle_singleton_list() {
        val list = getRandomListWithSentinel(1)
        assertEquals(list.next, getMiddle(list))
    }

    @Test
    fun middle_list_with_odd_dimension() {
        val list = getListWithSentinel(1, 20, 1)
        assertEquals(10, getMiddle(list).value)
    }

    @Test
    fun middle_list_with_even_dimension() {
        val list = getListWithSentinel(0, 20, 1)
        assertEquals(10, getMiddle(list).value)
    }
}

















