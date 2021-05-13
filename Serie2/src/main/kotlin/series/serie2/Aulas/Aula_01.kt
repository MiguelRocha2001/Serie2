package Aulas
/**
 * Using recursively
 */
fun fibonacci1(n: Int) :Int {
    return if (n < 2) n
    else fibonacci1(n-1) + fibonacci1(n-2)
}

/**
 * Using iteratively with array
 * The array memorizes the n terms
 */
fun fibonacci2(n: Int) :Int {
    val f = IntArray(n+2) // +1 pra gerir o espaço extra no caso de 0
    var i = 2
    f[0] = 0
    f[1] = 1
    while (i <= n) {
        f[i] = f[i-1] + f[i-2]
        ++i
    }
    return f[n]
}

/**
 * Using iteratively only 3 variables
 * [a] holds the n-2 term
 * [b] holds the n-1 term
 */
fun fibonacci3(n: Int) :Int {
    var a = 0
    var b = 1
    if (n == 0) return a
    if (n == 1) return b

    for (i in 2..n) {
        b += a      // b becomes the sum of the 2 prior terms
        a = b - a
    }
    return b
}

/**
 *
 */
fun power1(a: Int, n: Int) :Int {
    return  if (a == 0) 1 else a * power1(a,n-1)
}

/**
 * Calculates half operations of the previous function (power_1).
 */
fun power2(a: Int, n: Int) :Int {
    if (n == 0) return 1
    val z = power2(a,n/2)
    return if (n % 2 == 0) z * z else z * z * a
}

data class Triple(val left: Int, val sum: Double, val right: Int)

/**
 * Finds the subArray with the greatest using an exaustive way.
 */
fun maximumSubArray_1(array: DoubleArray, left: Int, right: Int) :Triple {
    var l = left
    var r = left - 1
    var bestSum = 0.0
    var actualSum :Double
    for (i in left..right) {
        actualSum = 0.0
        for (j in i..right) {
            actualSum += array[j]
            if (bestSum < actualSum) {
                bestSum = actualSum
                r = j
                l = i
            }
        }
    }
    return Triple(l,bestSum,r)
}

/**
 * Finds the subArray with the maximum sum using a linear way.
 * [a] -> lower index of the max subArray
 * [b] -> upper index of the max subArray
 * [c] -> lower index of the sliding subArray
 * [idx] -> lower index of the sliding subArray
 * see "https://www.youtube.com/watch?v=UncRSviH-cY"
 */
fun maximumSubArray_2(array: DoubleArray, left: Int, right: Int) :Triple {
    var sum = array[left]
    var currentSum = sum
    var a = left
    var b = left
    var c = left

    for (idx in left+1..right) {
        currentSum += array[idx]
        if (currentSum < array[idx]) {
            c = idx
            currentSum = array[idx]
        }
        if (sum < currentSum) {
            a = c
            b = idx
            sum = currentSum
        }
    }
    return Triple(a,sum,b)
}
