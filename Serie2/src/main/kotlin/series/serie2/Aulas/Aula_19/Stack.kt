package Aulas.Aula_19

interface Stack<E> {
    fun empty(): Boolean

    fun push(): Boolean

    fun peak(): E?

    fun pop(): E?
}