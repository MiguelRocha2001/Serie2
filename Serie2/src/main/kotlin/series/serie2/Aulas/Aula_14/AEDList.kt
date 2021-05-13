package Aulas.Aula_14

interface AEDList<E> {
    val size: Int

    fun contains(element: E): Boolean

    fun get(idx: Int): E?

    fun isEmpty(): Boolean
}