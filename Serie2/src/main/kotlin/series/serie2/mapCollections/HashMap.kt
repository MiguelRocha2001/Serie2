package series.serie2.mapCollections

import Aulas.Aula_20.HashSet
import series.serie2.Node

class HashMap<K, V> : MutableMap<K, V> {

    private var table: Array<MutableMap.MutableEntry<K, V>>? = null

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun put(key: K, value: V): V? {
        TODO("Not yet implemented")
    }

    override fun remove(key: K): V? {
        TODO("Not yet implemented")
    }

    override fun get(key: K): V? {
        val pos = key.hashCode() / size
        var current = table!![pos]

        return if (current == null) null
        else current.value
    }

    override fun iterator(): Iterator<MutableMap.MutableEntry<K, V>> {
        TODO("Not yet implemented")
    }

}
