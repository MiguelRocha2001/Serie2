package Aulas

/**
 * Given two ordered arrays: [leftArray] and [rightArray],
 * merges this two in order to [array].
 */
fun merge(array: IntArray, left: Int, leftArray: IntArray, rightArray: IntArray) {
    var iLeft = 0
    var iRight = 0
    var iA = left
    while (iLeft < leftArray.size || iRight < rightArray.size) {
        if (iLeft >= leftArray.size)
            array[iA] = rightArray[iRight++]
        else if (iRight >= rightArray.size)
            array[iA] = leftArray[iLeft++]
        else if (leftArray[iLeft] < rightArray[iRight])
            array[iA] = leftArray[iLeft++]
        else
            array[iA] = rightArray[iRight++]
        iA++
    }
}

/**
 * Used to call previous function merge() when both arrays are the same: [a]
 */
fun merge(a: IntArray, left: Int, mid: Int, right: Int) {
    val leftArray = IntArray(mid-left+1)
    val rightArray = IntArray(right-mid)
    for (i in left..mid) leftArray[i-left] = a[i]
    for (i in mid+1..right) rightArray[i-mid-1] = a[i]
    merge(a,left,leftArray,rightArray)
}

/**
 * Orders an array using divide-and-conquer method.
 */
fun mergeSort(a: IntArray, left: Int, right: Int) {
    if (left < right) {
        val mid = left + (right - left) / 2
        mergeSort(a,left,mid)
        mergeSort(a,mid+1,right)
        merge(a,left,mid,right)
    }
}

/**
 * Using recursion
 */
fun binarySearch1(array: IntArray, l: Int, r: Int, element: Int) : Int {
    if (l > r) return -1
    val mid = l + (r - l) / 2
    if (array[mid] == element) return mid
    return if (array[mid] > element) binarySearch1(array,l,mid-1,element)
    else binarySearch1(array,mid+1,r,element)
}

/**
 * Using Interactivity
 */
fun binarySearch2(array: IntArray, l: Int, r: Int, element: Int) : Int {
    var left = l
    var right = r
    var mid: Int
    while (left <= right) {
        mid = left + (right - left) / 2
        when {
            array[mid] == element -> return mid
            array[mid] > element -> right = mid - 1
            else -> left = mid + 1
        }
    }
    return -1
}

/**
 * Lower Bound mode
 */
fun binarySearch3(array: IntArray, l: Int, r: Int, element: Int) : Int {
    var left = l
    var right = r
    var mid: Int
    while (left <= right) {
        mid = left + (right - left) / 2
        when {
            array[mid] == element -> {
                if (mid == l) return mid
                if (array[mid] != array[mid-1])
                    return mid
                right = mid - 1
            }
            array[mid] > element -> right = mid - 1
            else -> left = mid + 1
        }
    }
    return -1
}

/**
 * Upper Bound mode
 */
fun binarySearch4(array: IntArray, l: Int, r: Int, element: Int) : Int {
    var left = l
    var right = r
    var mid: Int
    while (left <= right) {
        mid = left + (right - left) / 2
        when {
            array[mid] == element -> {
                if (mid == r) return mid
                if (array[mid] != array[mid+1])
                    return mid
                left = mid + 1
            }
            array[mid] > element -> right = mid - 1
            else -> left = mid + 1
        }
    }
    return -1
}

fun main() {
    var array1 = intArrayOf(1, 2, 4, 7, 7, 7, 7, 7, 9, 12)
    //println(binarySearch4(array1,0,array1.size-1,7))

    var array2 = intArrayOf(1, 18, 20, 23, 2, 3, 7, 4, 9, 12)
    mergeSort(array2,0,array2.size-1)
    print(array2.asList())
}