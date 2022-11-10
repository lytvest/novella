package ru.lytvest.novella

data class TextCommand(val texts: List<String>, val author: String) : Command() {
}