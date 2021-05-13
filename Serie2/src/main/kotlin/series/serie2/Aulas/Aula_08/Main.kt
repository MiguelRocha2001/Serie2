package aula9

import java.util.*
/*
fun main(){
    /*Java PriorityQueue - resizable*/
    val pq=PriorityQueue<Utente>({x:Utente, y:Utente -> x.priority-y.priority});
    val utente0=Utente("Joaquim",0,9)
    val utente1=Utente("Anabela",1,4)
    val utente2=Utente("Alice",2,3)
    val utente3=Utente("Pedro",3,6)
    val utente4=Utente("Manuel",4,7)
    val utente5=Utente("Beatriz",5,1)
    val utente6=Utente("Francisco",6,2)
    val utente7=Utente("Rodrigo",7,2)
    pq.offer(utente0)
    pq.offer(utente1)
    pq.offer(utente2)
    pq.offer(utente3)
    pq.offer(utente4)
    pq.offer(utente5)
    pq.offer(utente6)
    pq.offer(utente7)
    println(pq.toString())
    /*HeapQueue - not resizable */
    val heap=Array<Utente?>(10) { i -> null  }
    val positions=IntArray(10, { i -> -1  })
    val pqAED=AEDPriorityQueue(heap,positions,0,{x:Utente, y:Utente -> x.priority-y.priority})
    pqAED.offer(utente0)
    pqAED.offer(utente1)
    pqAED.offer(utente2)
    pqAED.offer(utente3)
    pqAED.offer(utente4)
    pqAED.offer(utente5)
    pqAED.offer(utente6)
    pqAED.offer(utente7)
    println(pqAED)
    println("############################")
    println(pqAED.size)
    println(pq.peek())
    println(pqAED.peek())
    val update1=Utente("Joaquim",0,5)
    pqAED.update(update1)
    println(pqAED)
    val update2=Utente("Joaquim",0,10)
    pqAED.update(update2 )
    println(pqAED)
    pq.poll()
    println(pq)
    pqAED.poll()
    println(pqAED)

    }


 */
