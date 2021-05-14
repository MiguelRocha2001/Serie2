package Aulas.Aula_14


class AEDArrayList<E>: AEDList<E> {
    private val elements: Array<E>

    constructor() {
        elements = arrayOfNulls<Any>(10) as Array<E>
    }

    override val size: Int
        get() = elements.size

    override fun contains(element: Int): Boolean {
        return elements.contains(element) // O(n)
    }

    override fun get(idx: Int): E {
        return elements[idx]
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }
}