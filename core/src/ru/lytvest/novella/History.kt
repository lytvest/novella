package ru.lytvest.novella

class History {
    lateinit var scene: NovelaScene
    var author = ""


    val commands = mutableListOf<Command>()

    fun text(vararg strs: String, author: String = this.author) {
        for (str in strs) {
            commands += TextCommand(str, author)
        }
    }


}