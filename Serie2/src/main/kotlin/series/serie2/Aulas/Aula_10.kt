package Aulas

import java.util.*

fun radixSort(a: Array<String>): Array<String> {
    if (a.isEmpty()) return a
    var new = Arrays.copyOf(a,a.size)
    var stringLength = a[0]!!.length
    //for (i in a.indices)
        //new = countingSort(new,i)
    return new
}

fun countingSort(a: IntArray, l: Int, r: Int, min: Int, max: Int): IntArray {
    val c = IntArray(max-min+1)
    val b = IntArray(r-l+1)
    for (i in l..r) c[a[i]-min]++
    for (j in 1 until c.size) c[j] += c[j-1]
    for (j in r downTo l) {
        b[c[a[j]+min]-1] = a[j]
        --c[a[j]]
    }
    return b
}

fun countingInternalSort(a: Array<String?>, pos: Int): Array<String?> {
    val c = IntArray(256)
    val b = arrayOfNulls<String>(a.size)
    for (i in a.indices) c[a[i]!![pos].toInt()]++
    for (j in 1..255) c[j] += c[j-1]
    for (j in a.size-1 downTo 0) {
        b[c[a[j]!![pos].toInt()]-1] = a[j]
        c[a[j]!![pos].toInt()]--
    }
    return b
}