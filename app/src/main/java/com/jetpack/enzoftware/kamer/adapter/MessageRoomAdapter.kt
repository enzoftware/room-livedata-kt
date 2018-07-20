package com.jetpack.enzoftware.kamer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jetpack.enzoftware.kamer.R
import com.jetpack.enzoftware.kamer.model.Message
import org.joda.time.DateTime
import java.util.*

class MessageRoomAdapter : RecyclerView.Adapter<MessageRoomViewHolder> {

    private var messageList : List<Message>
    private var context: Context

    constructor(context: Context, messageList: List<Message>){
        this.messageList = messageList
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageRoomViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.message_room_layout,parent,false)
        return MessageRoomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: MessageRoomViewHolder, position: Int) {
        val message = messageList[position]
        val currentDate = getCurrentDateTime()
        holder.content.text = message.content
        holder.contentDate.text = currentDate
        holder.contentDelete.setOnClickListener {
            // TODO : DELETE A MESSAGE WHEN THAT ITEM IS CLICKED

        }

    }

    private fun getCurrentDateTime(): String {
        val currentDate = Date()
        val dt = DateTime(currentDate)
        return dt.toString()
    }
}