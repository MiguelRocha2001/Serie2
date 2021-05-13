package Aulas.Aula_20

class HashSet<E>: MutableSet<E> {
    // Utilizar uma tabela de disperção com encadeamento externo com separação em listas duplamente ligadas com sentinela

    private data class Node<E>(val element: E, val next: Node<E>, previous: Node<E>)

    private var table: Array<Node<E>?>? = null
    override val size: Int = 0
    private var dimTable: Int = 0

    constructor() {
        table = arrayOfNulls<Node<Any>?>(11) as Array<Node<E>?>
        dimTable = 11
    }

    private fun index(e: E): Int {
        var pos = e.hashCode() / dimTable
        if (pos < 0) pos += dimTable
        return pos
    }

    private fun search(e: E, idx: Int): Node<E> {
        var current = table!!.get(idx)
        while (current != null) {
            if (current.element == e) return current
            current = current.next
        }
        return current
    }

    override fun add(element: E): Boolean {
        var pos = index(element)
        var node = search(element,pos)
        if (node != null) return false
        if (size/dimTable.toDouble() > 0.75) resize()
        pos = index(element)
        val new = Node(element)
        new.next = table!![pos]
        if (table!![pos] != null) table!![pos]!!.previous = new
        table!![pos] = new
    }
}