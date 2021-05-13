package Aulas.Aula_15

import Aulas.Aula_14.AEDMutableList

class LinkedListV1<E>: AEDMutableList<E> {
    private data class Node<E>(var item: E?, var next: Node<E>?)
    private var head: Node<E>? = null
    override var size: Int = 0

    override fun isEmpty(): Boolean {
        return head == null
    }

    override fun contains(element: E): Boolean {
        var aux = head
        while (aux != null) {
            if (aux.item!!.equals(element)) {
                return true
            }
            aux = aux.next
        }
        return false
    }

    override fun get(idx: Int): E? {
        var counter = 0
        var aux = head
        while (counter < idx) {
            aux = aux!!.next
            counter++
        }
        return aux!!.item
    }

    override fun add(element: E): Boolean {
        val novo: Node<E>
        var prev: Node<E>
        var aux = head
        while (aux!=null) {
            prev = aux
            aux = aux.next
        }
        if (prev == null) head = novo
        else prev.next = novo
        ++size
        return true
    }

    override fun remove(element: E): Boolean {
        var aux = head
        var prev: Node<E>! = null
        while (aux!=null) {
            if (aux.item!! == element) {
                if (prev == null) head = head!!.next
                else prev.next = aux.next
                --size
                return true
            }
            prev = aux
            aux = aux.next
            --size
        }
        return false
    }

    override fun add(index: Int, element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAt(index: Int): E? {
        TODO("Not yet implemented")
    }
}