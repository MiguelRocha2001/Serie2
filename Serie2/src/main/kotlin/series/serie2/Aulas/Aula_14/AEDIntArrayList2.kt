package Aulas.Aula_14

class AEDIntArrayList2: AEDIntList {
    private val elements: IntArray

    constructor() {
        elements = IntArray(10)
    }

    constructor(initialCapacity: Int) {
        elements = IntArray(initialCapacity)
    }

    override val size: Int
        get() = elements.size

    override fun contains(element: Int): Boolean {
        return elements.contains(element) // O(n)
    }

    override fun get(idx: Int): Int {
        return elements[idx]
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }
}