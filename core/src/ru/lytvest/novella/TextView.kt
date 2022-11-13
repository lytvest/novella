package ru.lytvest.novella

import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import ru.lytvest.chess.scenes.SceneManager

class TextView(val text: String) : Group() {

    val label: Label = Label("", SceneManager.skin, "text")
    val bg: Image = Image(SceneManager.skin, "fon")

    var duration = 0.08f
    var currentTime = 0f

    init {
        addActor(bg)
        addActor(label)
    }

    override fun sizeChanged() {
        super.sizeChanged()
        bg.setSize(width, height)
        label.setBounds(10f, height - label.prefHeight - 10f, label.prefWidth, label.prefHeight)
    }

    override fun act(delta: Float) {
        super.act(delta)
        currentTime += delta
        if (currentTime > duration) {
            currentTime -= duration
            timeTrigger()
        }
    }

    private fun timeTrigger() {
        if (isFull())
            return

        val size = label.text.length
        label.setText("" + label.text + text[size])
        if (label.prefWidth > width - 20f) {
            val index = label.text.trim().indexOfLast { it == ' ' }
            if (index >= 0) {
                label.text.setCharAt(index, '\n')
                label.invalidateHierarchy()
                label.setBounds(10f, height - label.prefHeight - 10f, label.prefWidth, label.prefHeight)
            }
        }
    }

    fun isFull(): Boolean {
        return label.text.length == text.length
    }
}