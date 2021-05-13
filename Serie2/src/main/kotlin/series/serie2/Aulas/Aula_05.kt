package Aulas

fun eliminaEsp(str: String): String {
    val n = str.length
    var nova = ""
    for (i in 0 until n) {
        if (str[i] != ' ')
            nova += str[i]
    }
    return nova
}