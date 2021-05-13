package Aulas.Aula_14

class AEDArrayListGeneric<E> {
    private val elements: Array<E>

    constructor() {
        elements = arrayOfNulls<Any?>(10) as Array<E>
    }
}