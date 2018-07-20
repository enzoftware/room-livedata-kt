package com.jetpack.enzoftware.kamer.db

    import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.jetpack.enzoftware.kamer.dao.MessageDAO
import com.jetpack.enzoftware.kamer.model.Message

@Database(entities = [(Message::class)], version = 2)
public abstract class AppDatabase : RoomDatabase() {


    abstract fun message(): MessageDAO

    companion object {
        private var appDatabase: AppDatabase ?= null

        fun getInstance(context: Context) : AppDatabase{
            if (appDatabase == null){
                synchronized(AppDatabase::class){
                    appDatabase = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "Kamer.db")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return appDatabase as AppDatabase
        }

        fun destroyInstance(){
            appDatabase = null
        }
    }



}