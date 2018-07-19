package com.jetpack.enzoftware.kamer.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Message")
class Message {
    @PrimaryKey(autoGenerate = true)
    var id: Int ?= null

    @ColumnInfo(name = "content")
    var content : String ?= null

    constructor(content:String){
        this.content = content
    }
}