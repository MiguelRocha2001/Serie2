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
    var left = list.next
    var right = list.previous
    while (left != right && left!!.next != right) {
        left = left!!.next
        right = right!!.previous
    }
    return left!!
}


/**
 * Sorts input list using bubble sort
 * @param list: Node<E> representing a single linked list, with sentinel and not circular.
 *
 */
fun <E> bubbleSort(list: Node<E>, cmp: Comparator<E>) {
    var current1 = list.next
    if (current1 != null) {
        var current2 = current1.next
        // if current1 and current2 exists, theres at least 2 elements in the list to sort.
        if (current2 != null) {
            // used to make the change between current1 and current2
            var preCurrent1 = list
            var terminal: Node<E>
            while (true) {
                if (cmp.compare(current1!!.value, current2!!.value) > 0) {
                    changeNode(preCurrent1,current1,current2)
                    terminal = current1
                    // to catch the last Node. Don't forget that current1 is still referring to current2 duo to the toggle
                    if (current1.next == null) break
                    current2 = current1.next
                }
                else {
                    current1 = current1.next
                    current2 = current2.next
                    terminal = current2!!
                }
                preCurrent1 = preCurrent1.next!!

            }

            while (terminal != list.next!!.next) {
                preCurrent1 = list
                current1 = list.next
                current2 = current1!!.next
                while (current2 != terminal) {
                    if (cmp.compare(current1!!.value, current2!!.value) > 0) {
                        changeNode(preCurrent1,current1,current2)
                        current2 = current1.next
                    }
                    else {
                        current1 = current1.next
                        current2 = current2.next
                    }
                    preCurrent1 = preCurrent1.next!!
                }
                terminal = current1!!
            }
        }
    }
}

/**
 * Toggles the node1 for the node2.
 */
fun <E> changeNode(preNode1: Node<E>, node1: Node<E>, node2: Node<E>) {
    node1.next = node2.next
    node2.next = node1
    preNode1.next = node2
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
    // still non circular
    val newList = Node<E>()
    newList.next = newList
    newList.previous = newList

    var lastInsertedNode: Node<E>? = null
    var current = list.next

    while (current != null) {

        if (lastInsertedNode == null || cmp.compare(lastInsertedNode.value,current.value) != 0) {
            lastInsertedNode = current
            current = current.next

            // inserir o lastInsertedNode na nova lista
            newList.previous!!.next = lastInsertedNode
            newList.previous = lastInsertedNode
            lastInsertedNode.previous = newList.previous
            lastInsertedNode.next = newList
        }

        else current = current.next
    }
    // to empty old list
    list.next = null
    return newList
}

