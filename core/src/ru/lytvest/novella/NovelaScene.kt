package ru.lytvest.novella

import com.badlogic.gdx.scenes.scene2d.ui.Image
import ru.lytvest.chess.scenes.Scene

class NovelaScene : Scene() {

    val dialogImage: Image = Image(skin, "fon")

    init {
        dialogImage.setBounds(3.h(), 3.h(), width() - 6.h(), 30.h())
        add { dialogImage }
    }

    fun nextCommand(command: Command) {
        when (command) {
            is TextCommand -> {
                dialogImage.isVisible = true
            }
        }
    }
}