package series.serie2

// Class Node
public class Node<E> {
    var previous: Node<E>? = null
    var next: Node<E>? = null
    var value: E? = null

    constructor() { }
    constructor(e: E) {
        value = e
    }
}


///////////////////////////////////////////////////////////////
/**
 * returns the node in the middle of the list
 * @param list: Node<E> representing a double linked list, with sentinel and circular
 * @return Node<E>
 */
fun <E> getMiddle(list: Node<E>): Node<E> {
    //COMMENT NEXT LINE AND IMPLEMENT YOUR SOLUTION
    throw UnsupportedOperationException()
}


/**
 * Sorts input list using bubble sort
 * @param list: Node<E> representing a single linked list, with sentinel and not circular.
 *
 */
fun <E> bubbleSort(list: Node<E>, cmp: Comparator<E>) {
    //COMMENT NEXT LINE AND IMPLEMENT YOUR SOLUTION
    throw UnsupportedOperationException()
}


/**
 * Given a doubly linked, non-circular and with sentinel list, ordered by comparator @cmp,
 * returns a doubly linked, circular and with sentinel list, without repetitions and
 * with the relative order preserved.
 * The resulting list must reuse the nodes in @list.
 * The list in @list must be empty.
 * @param list: Node<E> representing a double linked list, non-circular and with sentinel.
 * @param cmp: Comparator
 */
fun <E> distinct(list: Node<E>, cmp: Comparator<E>): Node<E> {
    //COMMENT NEXT LINE AND IMPLEMENT YOUR SOLUTION
    throw UnsupportedOperationException()
}











