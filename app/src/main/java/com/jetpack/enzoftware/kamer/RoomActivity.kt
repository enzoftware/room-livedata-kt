package com.jetpack.enzoftware.kamer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jetpack.enzoftware.kamer.utils.MessageDialog
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        add_btn.setOnClickListener {
            val dialog  = MessageDialog(this)
            dialog.addNewMessage(R.layout.dialog_layout)
        }
    }


}
