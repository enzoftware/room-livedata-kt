package com.jetpack.enzoftware.kamer.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.jetpack.enzoftware.kamer.model.Message

@Dao
interface MessageDAO {

    @Query("SELECT * FROM Message")
    fun getAllMessage() : LiveData<List<Message>>

    @Delete
    fun deleteMessage(message: Message)

    @Insert(onConflict = REPLACE)
    fun insertNewMessage(message: Message)

}