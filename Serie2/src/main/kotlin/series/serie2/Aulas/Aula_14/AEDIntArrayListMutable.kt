package Aulas.Aula_14

class AEDIntArrayListMutable: AEDIntMutableList {
    private var elements: IntArray

    constructor() {
        elements = IntArray(10)
    }

    constructor(initialCapacity: Int) {
        elements = IntArray(initialCapacity)
        size = initialCapacity
    }

    override var size: Int = 0

    override fun contains(element: Int): Boolean {
        return elements.contains(element) // O(n)
    }

    override fun get(idx: Int): Int {
        return elements[idx]
    }

    override fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    override fun add(element: Int): Boolean {
        if (size == elements.size)
            increaseCapacity()
        elements[size++] = element
        return true
    }

    override fun add(index: Int, element: Int) {
        elements[index] = element
    }

    private fun increaseCapacity() {
        val new = IntArray(2*elements.size)
        System.arraycopy(elements,0,new,0,size)
        elements = new
    }

    override fun remove(element: Int): Boolean {
        for (i in elements.indices) {
            if (elements[i].equals(element)) {
                System.arraycopy(elements,i+1,elements,i,size-i-1)
                --size
                return true
            }
        }
        return false
    }

    override fun removeAt(index: Int): Int {
        val aux = elements[index]
        System.arraycopy(elements,index+1,elements,index,size-index-1)
        --size
        return aux
    }
}