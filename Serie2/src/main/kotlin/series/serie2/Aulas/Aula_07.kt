package Aulas

fun left(i: Int) =  2 * i + 1

fun right(i: Int) = 2 * i + 2

fun parent(i: Int) = (i - 1) / 2

fun maxHeapify(v: IntArray, p: Int, n: Int, compare:(a: Int, b: Int) -> Int) {
    var l = left(p)
    var r = right(p)
    var largest = p

    if(l < n && compare(v[l],v[p]) > 0)
        largest = l
    if(r < n && compare(v[r],v[p]) > 0)
        largest = r
    if (largest == p) return
    exchange(v,p,largest)
    maxHeapify(v,largest,n,compare)
}

fun heapSort(v: IntArray, n: Int, compare: (a: Int, b: Int) -> Int) {
    buildMaxHeap(v,n,compare)
    for (i in (n-1) downTo 1) {
        exchange(v,0,i)
        maxHeapify(v,0,i,compare)
    }
}

fun buildMaxHeap(v: IntArray, n: Int, compare: (a: Int, b: Int) -> Int) {
    var p = parent(n-1)
    while (p >= 0) {
        maxHeapify(v,p,n,compare)
        --p
    }
}

fun main() {
    val array = intArrayOf(2,7,8,1,3,8,3,6,9,10,3,9)
    heapSort(array,12,{a: Int, b: Int -> a-b})
    print(array.asList())
}