package com.example.dataclassroomstorage.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.dataclassroomstorage.Model.User2

class DBHelper2 (context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME (ID2 INTEGER PRIMARY KEY " +
                "AUTOINCREMENT,SID2 TEXT,NAME2 TEXT,ADDRESS2 TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun insertData2(user: User2){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, user.id2)
        contentValues.put(COL_2, user.sid2)
        contentValues.put(COL_3, user.name2)
        contentValues.put(COL_4, user.adr2)
        db.insert(TABLE_NAME, null, contentValues)
    }

    fun updateData2(user: User2): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, user.id2)
        contentValues.put(COL_2, user.sid2)
        contentValues.put(COL_3, user.name2)
        contentValues.put(COL_4, user.adr2)
        db.update(TABLE_NAME, contentValues, "ID2 = ?", arrayOf(
            user.id2))
        return true
    }

    fun deleteData2(user: User2) : Int{
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "ID2 = ?", arrayOf(user.id2))
    }


    val allData2 : List<User2>
        get() {
            val listUser = ArrayList<User2>()
            val selectQuery = "select * from $TABLE_NAME"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if(cursor.moveToFirst()){
                do {
                    val user = User2()
                    user.id2 = cursor.getString(cursor.getColumnIndex(COL_1))
                    user.sid2 = cursor.getString(cursor.getColumnIndex(COL_2))
                    user.name2 = cursor.getString(cursor.getColumnIndex(COL_3))
                    user.adr2 = cursor.getString(cursor.getColumnIndex(COL_4))

                    listUser.add(user)
                } while (cursor.moveToNext())
            }
            return listUser
        }

    companion object {
        val DATABASE_NAME = "kelas2.db"
        val TABLE_NAME = "kelas2"
        val COL_1 = "ID2"
        val COL_2 = "SID2"
        val COL_3 = "NAME2"
        val COL_4 = "ADDRESS2"
    }
}