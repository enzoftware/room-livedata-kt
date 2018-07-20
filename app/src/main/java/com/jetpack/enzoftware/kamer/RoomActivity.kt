package com.jetpack.enzoftware.kamer

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jetpack.enzoftware.kamer.adapter.MessageRoomAdapter
import com.jetpack.enzoftware.kamer.db.AppDatabase
import com.jetpack.enzoftware.kamer.model.Message
import com.jetpack.enzoftware.kamer.utils.MessageDialog
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    private lateinit var roomAdapter: MessageRoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val recyclerView = findViewById<RecyclerView>(R.id.messages)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.hasFixedSize()

        val messageDAO = AppDatabase.getInstance(applicationContext).message()


        messageDAO.getAllMessage().observe(this, Observer { message : List<Message>? ->
            roomAdapter = MessageRoomAdapter(this,message)
            recyclerView.adapter = roomAdapter
        })


        add_btn.setOnClickListener {
            val dialog  = MessageDialog(this)
            dialog.addNewMessage(R.layout.dialog_layout)
        }
    }


}
