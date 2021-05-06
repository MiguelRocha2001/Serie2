package series.serie2.problema

interface KeyExtractor<E> {
    fun getKey(e: E): Int
}