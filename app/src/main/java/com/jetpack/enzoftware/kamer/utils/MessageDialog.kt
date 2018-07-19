package com.jetpack.enzoftware.kamer.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.jetpack.enzoftware.kamer.R
import com.jetpack.enzoftware.kamer.dao.MessageDAO
import com.jetpack.enzoftware.kamer.db.AppDatabase
import com.jetpack.enzoftware.kamer.model.Message

class MessageDialog {

    private lateinit var context: Context

    constructor(context: Context){
        this.context = context
    }

    fun addNewMessage(dialog_layout : Int){
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val subView: View = inflater.inflate(dialog_layout, null)
        val nameField = subView.findViewById<EditText>(R.id.enter_message)

        val builder: AlertDialog.Builder = AlertDialog.Builder(context).apply {
            setTitle("Add new message")
            setView(subView)
            create()
            setPositiveButton("ADD MESSAGE") { dialogInterface: DialogInterface, i: Int ->
                val message: String = nameField.text.toString()
                if(TextUtils.isEmpty(message)){
                    Toast.makeText(context,"Empty or invalid input",Toast.LENGTH_SHORT).show()
                }else{
                    val content = Message(message)
                    //add new message to database
                    val messageDAO : MessageDAO = AppDatabase.getInstance(context).message()
                    messageDAO.insertNewMessage(content)
                }
            }
            setNegativeButton("CANCEL") { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(context,"Task cancelled",Toast.LENGTH_SHORT).show()
            }
            show()
        }
    }

}