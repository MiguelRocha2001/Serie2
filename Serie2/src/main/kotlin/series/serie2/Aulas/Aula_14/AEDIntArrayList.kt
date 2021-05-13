package Aulas.Aula_14

class AEDIntArrayList(val elements: IntArray): AEDIntList {
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