package Aulas.Aula_17

interface Comparator<E> {
    fun compare(e1: E, e2: E): Int
}

interface Comparable<E> {
    fun compareTo(e: E): Int

}