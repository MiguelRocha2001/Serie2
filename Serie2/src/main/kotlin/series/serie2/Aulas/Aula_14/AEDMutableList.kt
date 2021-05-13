package Aulas.Aula_14

interface AEDMutableList<E>: AEDList<E> {

    fun add(element: E): Boolean

    fun remove(element: E): E?

    fun add(index: Int, element: E): Boolean

    fun removeAt(index: Int): E?

    override fun contains(element: E): Boolean

}