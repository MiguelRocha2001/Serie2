package Aulas.Aula_15

interface AEDList<E>: Iterable<E> {

}

interface Iterable<E> {
    fun iterator(): Iterator<E>
}

interface Iterator<E> {
    fun hasNext(): Boolean
    fun next(): E
}