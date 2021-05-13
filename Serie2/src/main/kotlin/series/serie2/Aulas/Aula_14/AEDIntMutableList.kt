package Aulas.Aula_14

interface AEDIntMutableList: AEDIntList {

    fun add(element: Int): Boolean

    fun remove(element: Int): Boolean

    fun add(index: Int, element: Int)

    fun removeAt(index: Int): Int
}