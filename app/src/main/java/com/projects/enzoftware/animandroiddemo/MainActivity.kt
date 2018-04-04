package com.projects.enzoftware.animandroiddemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var visible = false
        button_transition.setOnClickListener {
            TransitionManager.beginDelayedTransition(transition_container)
            visible = !visible
            text_transition.visibility = if (visible) View.VISIBLE else View.GONE
        }
    }
}
