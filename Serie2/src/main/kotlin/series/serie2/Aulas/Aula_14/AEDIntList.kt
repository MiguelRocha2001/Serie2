package Aulas.Aula_14

interface AEDIntList {
    val size: Int

    fun contains(element: Int): Boolean

    fun get(idx: Int): Int

    fun isEmpty(): Boolean
}