package com.example.projet

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MindOrksDBOpenHelper(context: Context,
                           factory: SQLiteDatabase.CursorFactory?) :
        SQLiteOpenHelper(context, DATABASE_NAME,
                factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME
                + " TEXT" + ")")
        db.execSQL(CREATE_PRODUCTS_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }
    fun addName(name: Name) {
        val values = ContentValues()
        values.put(COLUMN_NAME, name.userName)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }
    fun getAllName(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
    fun readData() : MutableList<Name>{
        var list : MutableList<Name> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM "+ TABLE_NAME
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do{
                var user = Name()
                user.id = result.getString(result.getColumnIndex(COLUMN_ID)).toInt()
                user.userName = result.getString(result.getColumnIndex(COLUMN_NAME))
                list.add(user)
            }while(result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun deleteData(){
        val db = this.writableDatabase

        db.delete(TABLE_NAME, COLUMN_ID + "=?", arrayOf(1.toString()))

        db.close()
    }

    /*fun updateData(){

        val db = this.writableDatabase
        val query = "SELECT * FROM "+ TABLE_NAME
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do{
                var cv = ContentValues()
                cv.put(COLUMN_NAME,result.getString(result.getColumnIndex(COLUMN_NAME)))
                db.update(TABLE_NAME,cv, COLUMN_ID+"=?", arrayOf(result.getString(result.getColumnIndex(COLUMN_ID))))
            }while(result.moveToNext())
        }

        result.close()
        db.close()
    }
    fun connexion(name:Name): Cursor? {
        val db = this.readableDatabase
        var user = Name()
        val test_name = user.userName
        val query = "SELECT userName FROM $TABLE_NAME WHERE userName=$test_name"
        var result = db.rawQuery(query,null)

        return result

    }*/
    fun connexion(userName:String) : Boolean{
        val columns = arrayOf(COLUMN_ID)
        val db = this.readableDatabase
        val selection = "$COLUMN_NAME = ?"
        val selectionArgs = arrayOf(userName)
        val cursor = db.query(TABLE_NAME,
        columns,
        selection,
        selectionArgs, null, null, null)
        val cursorcount = cursor.count
        cursor.close()
        db.close()
        if(cursorcount > 0)
            return true
        return false
    }

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "mindorksName.db"
        val TABLE_NAME = "name"
        val COLUMN_ID = "_id"
        val COLUMN_NAME = "username"
    }
}