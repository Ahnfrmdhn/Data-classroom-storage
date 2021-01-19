package com.example.dataclassroomstorage


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dataclassroomstorage.Adapter.ListUserAdapter
import com.example.dataclassroomstorage.DBHelper.DBHelper
import com.example.dataclassroomstorage.Model.User1
import kotlinx.android.synthetic.main.activity_main2.*
import java.lang.Exception

class MainActivity2 : AppCompatActivity() {

    internal var dbHelper = DBHelper(this)
    internal var lstUser:List<User1> = ArrayList<User1>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        handleInserts()
        handleUpdates()
        handleDeletes()
        handleViewing()

    }

    fun showToast(text: String){
        Toast.makeText(this@MainActivity2, text, Toast.LENGTH_LONG).show()
    }


    fun clearEditTexts(){
        nameTxt.setText("")
        sidTxt.setText("")
        adrTxt.setText("")
        idTxt.setText("")
    }


    fun handleInserts() {
        insertBtn.setOnClickListener {
            val user =  User1(
                idTxt.text.toString(),
                sidTxt.text.toString(),
                nameTxt.text.toString(),
                adrTxt.text.toString()
            )
            try {
                dbHelper.insertData(user)
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
        handleViewing()
    }


    fun handleUpdates(){
        updateBtn.setOnClickListener {
            val user =  User1(
                idTxt.text.toString(),
                sidTxt.text.toString(),
                nameTxt.text.toString(),
                adrTxt.text.toString()
            )
            try {
                val isUpdate = dbHelper.updateData(user)
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
        deleteBtn.setOnClickListener {
            val user =  User1(
                idTxt.text.toString(),
                sidTxt.text.toString(),
                nameTxt.text.toString(),
                adrTxt.text.toString()
            )
            try {
                dbHelper.deleteData(user)
                clearEditTexts()
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
        }
        handleViewing()
    }


    fun handleViewing() {
        viewBtn.setOnClickListener {
            lstUser = dbHelper.allData
            val adapter = ListUserAdapter(this@MainActivity2, lstUser, idTxt, sidTxt, nameTxt, adrTxt)
            listUser.adapter = adapter
        }
    }


}