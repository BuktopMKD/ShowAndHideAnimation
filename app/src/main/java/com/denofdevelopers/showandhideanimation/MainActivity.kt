package com.denofdevelopers.showandhideanimation

import android.os.Bundle
import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isSidePanelShown: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toggleButton.setOnClickListener {
            toggle(isSidePanelShown)
        }
    }

    private fun toggle(show: Boolean) {
        val transition: Transition = Slide(Gravity.END)
        transition.duration = 600
        transition.addTarget(R.id.sideInfoPanel)

        TransitionManager.beginDelayedTransition(rootContainer, transition)
        sideInfoPanel.visibility = if (!show) View.VISIBLE else View.GONE
        sideInfoPanel.bringToFront()
        isSidePanelShown = !isSidePanelShown
    }
}
