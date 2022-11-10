package ru.lytvest.novella

class History {
    lateinit var scene: NovelaScene
    var author = ""


    val commands = mutableListOf<Command>()

    fun text(vararg strs: String, author: String = this.author) {
        commands += TextCommand(strs.toList() , author)
    }


}