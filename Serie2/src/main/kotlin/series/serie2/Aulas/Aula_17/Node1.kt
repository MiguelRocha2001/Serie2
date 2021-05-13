package Aulas.Aula_17

class Node1<E>(var item: E, var next: Node1<E>?) {}

    /**
     * Without sentinela
     */
    fun <E> insertInOder(head: Node1<E>?, element: E, cmp: Comparator<E>): Node1<E> {
        val new = Node1(element,null)
        var current = head
        var prev: Node1<E>? = null
        while (current != null) {
            if (cmp.compare(current.item,element) < 0) {
                prev = current
                current = current.next
            }
            else break
        }
        return if (prev == null) {
            new.next = head
            new
        } else {
            new.next = current
            prev.next = new
            head!!
        }
    }

    class Node2<E>(var item: E, var next: Node2<E>?, var previous: Node2<E>?) {}

    /**
     * With sentinela, double linked and circular.
     */
    fun <E> merge(list1: Node2<E>, list2: Node2<E>, cmp: Comparator<E>) {
        var head1 = list1.next
        var head2 = list2.next
        while (head1 != list1 && head2 != list2) {
            if (cmp.compare(head1!!.item, head2!!.item) <= 0) {
                head1 = head1.next
            } else {
                head1.previous!!.next = head2
                head2!!.previous = head1!!.previous
                head1.previous = head2
                head2 = head2.next
                head1.previous!!.next = head1
            }
        }
        if (head2 != list2) {
            list1!!.previous!!.next = head1
            head2!!.previous = list1.previous
            list1.previous = list2.previous
            list2.previous!!.next = list1
        }
        list2.previous = list2
        list2.next = list2
    }
