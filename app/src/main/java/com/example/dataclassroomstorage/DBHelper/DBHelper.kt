package com.example.dataclassroomstorage.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.dataclassroomstorage.Model.User1

class DBHelper (context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY " +
                "AUTOINCREMENT,SID TEXT,NAME TEXT,ADDRESS TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun insertData(user: User1){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_11, user.id)
        contentValues.put(COL_22, user.sid)
        contentValues.put(COL_33, user.name)
        contentValues.put(COL_44, user.adr)
        db.insert(TABLE_NAME, null, contentValues)
    }

    fun updateData(user: User1): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_11, user.id)
        contentValues.put(COL_22, user.sid)
        contentValues.put(COL_33, user.name)
        contentValues.put(COL_44, user.adr)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(
            user.id))
        return true
    }

    fun deleteData(user: User1) : Int{
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "ID = ?", arrayOf(user.id))
    }


    val allData : List<User1>
        get() {
            val listUser = ArrayList<User1>()
            val selectQuery = "select * from $TABLE_NAME"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if(cursor.moveToFirst()){
                do {
                    val user = User1()
                    user.id = cursor.getString(cursor.getColumnIndex(COL_11))
                    user.sid = cursor.getString(cursor.getColumnIndex(COL_22))
                    user.name = cursor.getString(cursor.getColumnIndex(COL_33))
                    user.adr = cursor.getString(cursor.getColumnIndex(COL_44))

                    listUser.add(user)
                } while (cursor.moveToNext())
            }
            return listUser
        }

    companion object {
        val DATABASE_NAME = "kelas123.db"
        val TABLE_NAME = "kelas1"
        val COL_11 = "ID"
        val COL_22 = "SID"
        val COL_33 = "NAME"
        val COL_44 = "ADDRESS"
    }
}