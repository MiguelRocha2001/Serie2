package series.serie2

import org.junit.jupiter.api.Assertions
import java.util.*


fun IntProgression.toArray() =
    IntArray(this.count()).also { forEachIndexed { index, i -> it[index] = i } }


object ListUtilTest {
    /*
	 * For double linked and circular lists with sentinel
	 */
    fun <E> getSize(list: Node<E>): Int {
        var size = 0
        var curr: Node<E>? = list
        while (curr!!.next != list) {
            ++size
            curr = curr.next
        }
        return size
    }

    fun <E> emptyListWithSentinel(): Node<E> {
        val empty = Node<E>()
        empty.previous = empty
        empty.next = empty.previous
        return empty
    }

    fun getRandomListWithSentinel(dimension: Int): Node<Int> {
        val r = Random()
        var list = emptyListWithSentinel<Int>()
        for (i in 0 until dimension) {
            val v = r.nextInt() % 40
            list.previous = newNode(v, list.previous, list)
            list.previous!!.previous!!.next = list.previous
        }
        return list
    }

    internal fun <T> assertListEquals(expected: Node<T>, result: Node<T>, cmp: Comparator<T?>) {
        var listExpected = expected.next
        var listResult = result.next
        while (listExpected != expected && listResult != result) {
            Assertions.assertEquals(0, cmp.compare(listExpected!!.value, listResult!!.value))
            listExpected = listExpected.next
            listResult = listResult.next
        }
        Assertions.assertTrue(listExpected == expected)
        Assertions.assertTrue(listResult == result)
    }

    fun <E> isEmptyListWithSentinel(list: Node<E>): Boolean {
        return list.next == list && list.previous == list
    }

    fun <E> makeList(vararg array: E): Node<E> {
        val list: Node<E> = emptyListWithSentinel()
        for (v in array) {
            list.previous = newNode(v, list.previous, list)
            list.previous!!.previous!!.next = list.previous
        }
        return list
    }

    fun getListWithSentinel(begin: Int, end: Int, step: Int): Node<Int> {
        val s = step
        val progression = begin..end step s
        return makeList<Int>(*progression.toArray().toTypedArray())
    }

    fun <E> isListSortedAndDistinct(list: Node<E>, cmp: Comparator<E?>): Boolean {
        var curr = list.next
        if (curr == list && curr == list.previous) // List is empty
            return true
        while (curr!!.next != list) {
            if (cmp.compare(curr.value, curr.next!!.value) >= 0)
                return false
            curr = curr.next
        }
        return true
    }

    ////////////////////////////////////////////////////////////////////
    /*
	 * For double linked and non-circular lists with no sentinel
	 */
    fun <E> emptyListWithoutSentinel(): Node<E>? {
        return null
    }

    fun getListWithoutSentinel(begin: Int, end: Int, step: Int): Node<Int>? {
        var beg = begin
        if (end < beg) return null
        val list = Node<Int>()
        var cur: Node<Int>? = list
        cur!!.value = beg
        beg += step
        while (beg < end) {
            val next = Node<Int>()
            cur!!.next = next
            next.previous = cur
            next.value = beg
            cur = cur.next
            beg += step
        }
        return list
    }

    fun getRandomListWithoutSentinel(dimension: Int): Node<Int?>? {
        val r = Random()
        var list = emptyListWithoutSentinel<Int?>()
        for (i in 0 until dimension) {
            val novo = newNode<Int?>(r.nextInt() % 40)
            novo.next = list
            if (list != null)
                list.previous = novo
            list = novo
        }
        return list
    }

    fun getListWithoutSentinel(array: ArrayList<Int?>): Node<Int>? {
        if (array.size == 0) return null
        val list = Node<Int>()
        var cur: Node<Int>? = list
        cur!!.value = array[0]
        for (i in 1 until array.size) {
            val next = Node<Int>()
            cur!!.next = next
            next.previous = cur
            next.value = array[i]
            cur = cur.next
        }
        return list
    }

    fun <E> getNNode(N: Int, list: Node<E>?): Node<E>? {
        var lst = list
        for (i in 0 until N) {
            if (lst == null) return null
            lst = lst.next
        }
        return lst
    }

    fun <E> isSorted(
        list: Node<E>?, last: Node<E>,
        cmp: Comparator<E?>
    ): Boolean {
        var curr = list
        if (curr == null || curr == last) return true
        while (curr!!.next != last) {
            if (cmp.compare(curr.value, curr.next!!.value) > 0) return false
            curr = curr.next
        }
        return true
    }

    fun <E> isSorted(list: Node<E>, cmp: Comparator<E?>): Boolean {
        var curr = list.next
        if (curr == list || curr == list.previous) return true
        while (curr!!.next != list) {
            if (cmp.compare(curr.value, curr.next!!.value) > 0) return false
            curr = curr.next
        }
        return true
    }

    /*
	 *
	 * Generic Methods
	 */
    fun <E> newNode(v: E): Node<E> {
        val result = Node<E>()
        result.value = v
        return result
    }

    fun <E> newNode(v: E, p: Node<E>?, n: Node<E>?): Node<E> {
        val result = newNode(v)
        result.previous = p
        result.next = n
        return result
    }

    ////////////////////////////////////////////////////////////////////
    /*
	 * For single linked and non-circular lists with sentinel
	 */
    fun <E> emptySListWithSentinel(): Node<E> {
        val empty = Node<E>()
        return empty
    }

    fun <E> isSListSorted(list: Node<E>, cmp: Comparator<E?>): Boolean {
        var curr = list.next
        if (curr == null) return true
        while (curr != null && curr.next != null) {
            if (cmp.compare(curr.value, curr.next!!.value) > 0)
                return false
            curr = curr.next
        }
        return true
    }

    fun getRandomSList(dimension: Int): Node<Int> {
        val r = Random()
        var list = emptySListWithSentinel<Int>()
        for (i in 0 until dimension) {
            val novo = newNode<Int>(r.nextInt() % 40)
            novo.next = list.next
            list.next = novo
        }
        return list
    }

    fun getSListWithSentinel(array: ArrayList<Int>): Node<Int> {
        var list = emptySListWithSentinel<Int>()
        if (array.size == 0)
            return list
        for (i in array.size-1 downTo 0) {
            val novo = newNode<Int>(array[i])
            novo.next = list.next
            list.next = novo
        }
        return list
    }

    fun getSListWithSentinel(begin: Int, end: Int, step: Int): Node<Int> {
        val list = Node<Int>()
        var beg = begin
        if (end < beg)
            return list
        var cur: Node<Int>? = list
        while (beg <= end) {
            val next = Node<Int>()
            cur!!.next = next
            next.value = beg
            cur = cur.next
            beg += step
        }
        return list
    }

    ////////////////////////////////////////////////////////////////////
    /*
	 * For double linked lists with sentinel, but non-circular
	 */
    fun <E> emptyListWithSentinelNonCircular(): Node<E> {
        val empty = Node<E>()
        empty.previous = null
        empty.next = null
        return empty
    }

    fun <E> isEmptyListWithSentinelNonCircular(list: Node<E>): Boolean {
        return list.next == null && list.previous == null
    }

    fun <E> makeDListNonCircular(vararg array: E): Node<E> {
        val list: Node<E> = emptyListWithSentinelNonCircular()
        var curr: Node<E>? = list
        for (v in array) {
            curr!!.next = newNode(v, list, null)
            curr = curr.next
        }
        return list
    }

    fun getDListWithSentinelNonCircular(begin: Int, end: Int, step: Int): Node<Int> {
        val s = step
        val progression = begin..end step s
        return makeDListNonCircular(*progression.toArray().toTypedArray())
    }

}














