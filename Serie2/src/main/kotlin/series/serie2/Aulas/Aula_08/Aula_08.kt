package Aulas

data class AEDPriorityQueue(val heap: Array<Utente?>, val positions: IntArray, var size: Int, val compare: (a: Utente, b: Utente) -> Int)

data class Utente(val name: String, val utenteId: Int, var priority: Int)

fun AEDPriorityQueue.offer(element: Utente) {
    heap[size] = element
    positions[element.utenteId] = size
    decreaseKey(size)
    size++
}

private fun AEDPriorityQueue.decreaseKey(i: Int) {
    var i = i
    while (i > 0 && compare(heap[i]!!,heap[parent(i)]!!) < 0) {
        exchange(positions,i,parent(i))
        exchange(positions,heap[i]!!.utenteId, heap[parent(i)]!!.utenteId)
        i = parent(i)
    }
}

fun AEDPriorityQueue.peek(): Utente? {
    return if (size == 0) return null else heap[0]

}

fun AEDPriorityQueue.pool(): Utente? {
    val element = peek()
    if (element != null) {
        --size
        heap[0] = heap[size]
        positions[heap[size]!!.utenteId] = -1
        heap[size] = null
        positions[heap[0]!!.utenteId] = 0
        miniHeapify(0)
    }
    return element
}

private fun AEDPriorityQueue.miniHeapify(i: Int) {
    val l = left(i)
    val r = right(i)
    var smallest = i
    if (l < size && compare(heap[l]!!,heap[smallest]!!) < 0)
        smallest = l
    if (r < size && compare(heap[r]!!,heap[smallest]!!) < 0)
        smallest = r
    if (smallest == i) return
    exchange(positions,i,smallest)
    exchange(positions,heap[i]!!.utenteId,heap[smallest]!!.utenteId,)
    miniHeapify(smallest)
}

private fun AEDPriorityQueue.update(newStatus: Utente) {
    val oldStatus = heap[positions[newStatus.utenteId]]
    heap[positions[newStatus.utenteId]] = newStatus
    if (compare(oldStatus!!,newStatus) < 0)
        miniHeapify(positions[newStatus.utenteId])
    else
        decreaseKey(positions[newStatus.utenteId])

}