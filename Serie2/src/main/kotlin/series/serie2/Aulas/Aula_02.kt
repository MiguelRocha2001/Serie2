package Aulas

fun insertionSort(a: IntArray, left: Int, right: Int) : IntArray {
    for (j in left+1..right) {
        val v = a[j]
        var i = j
        while (i > left && v < a[i-1]) {
            a[i] = a[i-1]
            --i
        }
        a[i] = v
    }
    return a
}

/**
 * Not stable: uses exchange.
 */
fun selectionSort1(a: IntArray, left: Int, right: Int) : IntArray {
    var min: Int
    for (j in left until right) {
        min = j
        for (i in j+1..right) {
            if (a[i] < a[min])
                min = i
        }
        exchange(a,j,min)
    }
    return a
}

/**
 * Stable: uses exchangeShift.
 * Array positions are shifted without scrwing up original order when
 * exchange happens.
 */
fun selectionSort2(a: IntArray, left: Int, right: Int) : IntArray {
    var min: Int
    for (j in left until right) {
        min = j
        for (i in j+1..right) {
            if (a[i] < a[min])
                min = i
        }
        exchangeShift(a,j,min)
    }
    return a
}

/**
 * Optimized: when theres no changes on the array, returns.
 */
fun bubbleSort(a: IntArray, left: Int, right: Int) : IntArray {
    var sorted: Boolean
    for (j in left until right) {
        sorted = false
        for (i in right downTo j+1) {
            if (a[i] < a[i-1]) {
                exchange(a, i - 1, i)
                sorted = true
            }
        }
        if (!sorted) return a
    }
    return a
}

/**
 * Changes two values given by their indexes in an array.
 */
fun exchange(a: IntArray, i1: Int, i2: Int) {
    val temp = a[i1]
    a[i1] = a[i2]
    a[i2] = temp
}

/**
 * Insert [i2] in [i1].
 * The array shifts all positions from [i1] until [i2] to the right.
 */
fun exchangeShift(a: IntArray, i1: Int, i2: Int) : IntArray {
    val last = a[i2]
    for (i in i2 downTo i1+1) {
        a[i] = a[i-1]
    }
    a[i1] = last
    return a
}

fun main() {
    val a = intArrayOf(5, 7, 3, 12, 10, 24, 2)
    val sorted = bubbleSort(a,0,6)
    print(sorted.asList())

}