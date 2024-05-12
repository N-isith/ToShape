package com.example.toshape

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private const val DB_NAME = "BMI"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "BMIlist"
        private const val HEIGHT = "height"
        private const val WEIGHT = "weight"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($HEIGHT TEXT, $WEIGHT TEXT);"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }

    fun getAllBMI(): List<BMIModel> {
        val BMIlist = ArrayList<BMIModel>()
        val db = readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val cursor: Cursor? = db.rawQuery(selectQuery, null)
        cursor?.use {
            while (it.moveToNext()) {
                val bmis = BMIModel()
                bmis.weight = it.getString(it.getColumnIndexOrThrow(WEIGHT))
                bmis.height = it.getString(it.getColumnIndexOrThrow(HEIGHT))
                BMIlist.add(bmis)
            }
        }
        cursor?.close()
        return BMIlist
    }

    fun addBMI(bmis: BMIModel): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(WEIGHT, bmis.weight)
            put(HEIGHT, bmis.height)
        }
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        return _success != -1L
    }

    fun getBMI(_weight: String): BMIModel? {
        val db = readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $WEIGHT = ?"
        val cursor: Cursor? = db.rawQuery(selectQuery, arrayOf(_weight))
        var bmis: BMIModel? = null
        cursor?.use {
            if (it.moveToFirst()) {
                bmis = BMIModel().apply {
                    weight = it.getString(it.getColumnIndexOrThrow(WEIGHT))
                    height = it.getString(it.getColumnIndexOrThrow(HEIGHT))
                }
            }
        }
        cursor?.close()
        return bmis
    }

    fun deleteBMII(_weight: String): Boolean {
        val db = writableDatabase
        val _success = db.delete(TABLE_NAME, "$WEIGHT = ?", arrayOf(_weight))
        db.close()
        return _success != -1
    }

    fun updateBMI(bmis: BMIModel): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(WEIGHT, bmis.weight)
            put(HEIGHT, bmis.height)
        }
        val _success = db.update(TABLE_NAME, values, "$WEIGHT = ?", arrayOf(bmis.weight))
        db.close()
        return _success != -1
    }
}
