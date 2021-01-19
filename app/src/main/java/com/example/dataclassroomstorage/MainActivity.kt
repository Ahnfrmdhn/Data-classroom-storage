package com.example.dataclassroomstorage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn2.setOnClickListener {
            intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        btn1.setOnClickListener {
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        savedData1()
        loadData1()
        savedData2()
        loadData2()

        btnOK2.setOnClickListener {
            savedData2()
            loadData2()
        }

        btnOK1.setOnClickListener {
            savedData1()
            loadData1()
        }
    }

    private fun loadData1(){
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", null)

        btn1.text = ("$savedString")
    }

    private fun savedData1() {
        val insertedText = btn1Txt.text.toString()

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_KEY", insertedText)
        }.apply()
    }

    private fun loadData2() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", null)

        btn2.text = ("$savedString")
    }

    private fun savedData2() {
        val insertedText = btn2Txt.text.toString()

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_KEY", insertedText)
        }.apply()
    }


}