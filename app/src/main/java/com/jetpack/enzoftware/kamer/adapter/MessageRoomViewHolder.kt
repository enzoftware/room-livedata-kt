package com.jetpack.enzoftware.kamer.adapter


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MessageRoomViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    lateinit var content : TextView
    lateinit var contentDelete : ImageView

}