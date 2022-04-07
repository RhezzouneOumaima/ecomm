package com.example.etudiantapp.Model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
//pour créer les tables de notre BD
class DbHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    companion object
    {
        final val dbName="Book.db"
        final val version=1
        final val dbTableBook="Book"
        final val BookID="ID"
        final val BookNom="NOM"
        final val BookPrix="PRIX"
        final val BookQTE="QTE"
        final val BookIMG="IMG"
        final val dbTableUser="User"
        final val UserID="ID"
        final val UserName="NAME"
        final val UserMail="MAIL"
        final val UserMdp="MDP"

    }
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE $dbTableBook ( $BookID INTEGER PRIMARY KEY AUTOINCREMENT, $BookNom TEXT NOT NULL, $BookPrix TEXT NOT NULL, $BookQTE TEXT NOT NULL, $BookIMG INTEGER NOT NULL);")
        db!!.execSQL("CREATE TABLE $dbTableUser ( $UserID INTEGER PRIMARY KEY AUTOINCREMENT, $UserName TEXT NOT NULL, $UserMail TEXT NOT NULL, $UserMdp TEXT NOT NULL);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $databaseName;")
    }
}