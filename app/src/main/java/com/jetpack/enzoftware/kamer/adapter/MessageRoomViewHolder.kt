package com.jetpack.enzoftware.kamer.adapter


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.jetpack.enzoftware.kamer.R
import kotlinx.android.synthetic.main.message_room_layout.view.*

class MessageRoomViewHolder : RecyclerView.ViewHolder {

    lateinit var content : TextView
    lateinit var contentDate : TextView
    lateinit var contentDelete : ImageView

    constructor(itemView: View) : super(itemView) {
        content = itemView.findViewById(R.id.content)
        contentDelete = itemView.findViewById(R.id.content_delete)
        contentDate = itemView.findViewById(R.id.content_date)
    }





}