package Aulas

import java.util.*

/**
 * Selects a pivot, witch is the a[right], and separates the smaller numbers to the left
 * and the greater numbers to the right.
 */
fun partition(a: IntArray, left: Int, right: Int): Int {
    var i = left - 1
    var j = right
    val pivot = a[right]
    while (true) {
        while (i < right && a[++i] < pivot) ;
        while (j > left && pivot < a[--j]) ;
        if (j == left) break
        if (i >= j) break
        exchange(a,i,j)
    }
    exchange(a,i,right)
    return i
}

/**
 * Orders an array using multiple partitions, recursively.
 */
fun quickSort(a: IntArray, left: Int, right: Int) {
    if (right <= left) return
    val i = partition(a,left,right)
    quickSort(a,left,i-1)
    quickSort(a,i+1,right)
}

/**
 * Orders an array using multiple partitions, Iteratively.
 */
fun quickSortIterative(a: IntArray, left: Int, right: Int) {
    var left = left
    var right = right
    val s = Stack<Int>() // store indexes of the "subArrays"
    s.push(left)
    s.push(right)
    while (!s.isEmpty()) {
        right = s.pop()
        left = s.pop()
        if (right < left) continue
        val i = partition(a,left,right)
        if (i-left > right - i) {
            s.push(left)
            s.push(i - 1)
        }
        s.push(i+1)
        s.push(right)
        if (i-left <= right - i) {
            s.push(left)
            s.push(i-1)
        }
    }
}