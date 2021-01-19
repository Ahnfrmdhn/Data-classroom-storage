package com.example.dataclassroomstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dataclassroomstorage.Adapter.ListUserAdapter2
import com.example.dataclassroomstorage.DBHelper.DBHelper2
import com.example.dataclassroomstorage.Model.User2
import kotlinx.android.synthetic.main.activity_main3.*
import java.lang.Exception

class MainActivity3 : AppCompatActivity() {

    internal var dbHelper = DBHelper2(this)
    internal var lstUser:List<User2> = ArrayList<User2>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()

    }

    fun showToast(text: String){
        Toast.makeText(this@MainActivity3, text, Toast.LENGTH_LONG).show()
    }

    fun clearEditTexts(){
        nameTxt2.setText("")
        sidTxt2.setText("")
        adrTxt2.setText("")
        idTxt2.setText("")
    }

    fun handleInserts() {
        insertBtn2.setOnClickListener {
            val user = User2(
                idTxt2.text.toString(),
                sidTxt2.text.toString(),
                nameTxt2.text.toString(),
                adrTxt2.text.toString()
            )
            try {
                dbHelper.insertData2(user)
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
        handleViewing()
    }

    fun handleUpdates(){
        updateBtn2.setOnClickListener {
            val user =  User2(
                idTxt2.text.toString(),
                sidTxt2.text.toString(),
                nameTxt2.text.toString(),
                adrTxt2.text.toString()
            )
            try {
                val isUpdate = dbHelper.updateData2(user)
                if (isUpdate == true)
                    showToast("Data Updated Successfully")
                else
                    showToast("Data Not Updated")
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
        handleViewing()
    }

    fun handleDeletes(){
        deleteBtn2.setOnClickListener {
            val user = User2(
                idTxt2.text.toString(),
                sidTxt2.text.toString(),
                nameTxt2.text.toString(),
                adrTxt2.text.toString()
            )
            try {
                dbHelper.deleteData2(user)
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
        handleViewing()
    }

    fun handleViewing() {
        viewBtn2.setOnClickListener {
            lstUser = dbHelper.allData2
            val adapter = ListUserAdapter2(this@MainActivity3, lstUser, idTxt2, sidTxt2, nameTxt2, adrTxt2)
            listUser2.adapter = adapter
        }
    }


}