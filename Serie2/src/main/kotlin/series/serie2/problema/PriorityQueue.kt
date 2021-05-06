package series.serie2.problema

interface PriorityQueue<E, P> {
    fun add(elem: E, prio: P)
    fun peek(): E?
    fun poll(): E?
    fun update(key: Int, prio: P)
    fun remove(key: Int)
    fun empty(): Boolean
}