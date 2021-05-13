package Aulas.Aula_19

public interface Queue<E> {
    fun empty(): Boolean

    fun peek(): E?

    fun offer(): Boolean

    fun pool(): E?
}