package com.example.ecomm.Model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.etudiantapp.Model.DbHelper
//Pour l'affichage au panier et l'interaction
class BookDao {
    var helper: DbHelper
    var db: SQLiteDatabase

    constructor(ctx: Context)
    {
        helper= DbHelper(ctx, DbHelper.dbName,null, DbHelper.version)
        db=helper.writableDatabase
    }


    fun ajoutBook(e:Book):Long
    {
        var values= ContentValues()
        values.put(DbHelper.BookNom,e.nom)
        values.put(DbHelper.BookPrix,e.prix)
        values.put(DbHelper.BookQTE,e.qte)
        values.put(DbHelper.BookIMG,e.img)
        return db.insert(DbHelper.dbTableBook,null,values)
    }
    fun deleteAll()
    {
        db.delete(DbHelper.dbTableBook,null,null)
    }
    @SuppressLint("Range")
    fun getAll():ArrayList<Book>
    {
        var allBooks=ArrayList<Book>()
        var curseur=db.rawQuery("SELECT * FROM ${DbHelper.dbTableBook}",null)
        if(curseur.moveToFirst()){
            do {
                var id=curseur.getInt(curseur.getColumnIndex(DbHelper.BookID))
                var nom=curseur.getString(curseur.getColumnIndex(DbHelper.BookNom))
                var prix=curseur.getString(curseur.getColumnIndex(DbHelper.BookPrix))
                var qte=curseur.getString(curseur.getColumnIndex(DbHelper.BookQTE))
                var img=curseur.getInt(curseur.getColumnIndex(DbHelper.BookIMG))
                var b=Book(id,nom,prix,qte,img)
                allBooks.add(b)

            }while (curseur.moveToNext())
        }
        return allBooks
    }
}