package ru.lytvest.novella

import com.badlogic.gdx.scenes.scene2d.ui.Image
import ru.lytvest.chess.scenes.Scene

class NovelaScene : Scene() {

    var dialog: TextView? = null

    init {
        nextCommand(TextCommand(
            "when можно использовать и как выражение, и как оператор. " +
                    "При использовании его в виде выражения значение первой ветки, удовлетворяющей условию, становится значением всего выражения. " +
                    "При использовании в виде оператора значения отдельных веток отбрасываются. " +
                    "В точности как if: каждая ветвь может быть блоком и её значением является значение последнего выражения блока. " +
                    "Значение ветки else вычисляется в том случае, когда ни одно из условий в других ветках не", "Athhho"))
    }

    fun nextCommand(command: Command) {
        when (command) {
            is TextCommand -> {
                dialog?.remove()
                dialog = TextView(command.text)
                dialog?.setBounds(10f, 10f, width() - 20f, height() * 0.3f)
                add { dialog!! }
            }
        }
    }
}