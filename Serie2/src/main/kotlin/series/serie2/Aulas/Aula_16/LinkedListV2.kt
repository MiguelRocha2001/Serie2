package Aulas.Aula_16

import Aulas.Aula_14.AEDMutableList

class LinkedListV2<E>: AEDMutableList<E> {
    private data class Node<E>(val item: E?, var next: Node<E>?, var previous: Node<E>?)
    private var head: Node<E>? = null
    override var size: Int = 0

    constructor() {
        head = Node(null,null,null)
        head!!.next = head
        head!!.previous = head
    }

    override fun isEmpty(): Boolean {
        return head!!.next == head
    }

    private fun search(element: E): Node<E>? {
        var aux = head!!.next
        while (aux != head) {
            if (aux!!.item == element) return aux
            aux = aux.next
        }
        return null
    }

    override fun contains(element: E): Boolean {
        return  search(element) != null
    }

    override fun add(element: E): Boolean {
        val new = Node(element,head,head!!.previous)
        head!!.previous!!.next = new
        head!!.previous = new
        ++size
        return true
    }

    override fun removeAt(index: Int): E? {
        var aux = head
        for (ind in 0 until index) {
            aux = aux!!.next
        }
        aux!!.previous!!.next = aux.next
        aux.next!!.previous = aux.previous
        --size
        return aux.item
    }

    override fun add(index: Int, element: E): Boolean {
        var aux = head
        for (ind in 0 until index) {
            aux = aux!!.next
        }
        var new = Node(element,null,null)
        new.previous = aux!!.previous!!
        new.next = aux
        aux!!.previous!!.next = new
        aux.previous = new
        ++size
        return true
    }

    override fun get(idx: Int): E? {
        var aux = head
        for (ind in 0 until idx) {
            aux = aux!!.next
        }
        return aux!!.item
    }

    override fun remove(element: E): E? {
        var aux = head
        while (aux!!.item != element) {
            aux = aux!!.next
        }
        aux!!.previous!!.next = aux.next
        aux.next!!.previous = aux.previous
        --size
        return aux.item
    }

    override fun iterator(): Iterator<E> {
        //return MyIterator()
        return object: Iterator<E> {
            var current = head!!.next
            override fun hasNext(): Boolean {
                return current != head
            }

            override fun next(): E {
                val x = current!!.item
                current = current!!.next
                return x!!
            }
        }
    }

}