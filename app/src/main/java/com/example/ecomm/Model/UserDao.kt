package com.example.ecomm.Model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.etudiantapp.Model.DbHelper

class UserDao {
    var helper: DbHelper
    var db: SQLiteDatabase

    constructor(ctx: Context)
    {
        helper= DbHelper(ctx, DbHelper.dbName,null, DbHelper.version)
        db=helper.writableDatabase
    }
    fun ajoutUser(e:User):Long
    {
        var values= ContentValues()
        values.put(DbHelper.UserName,e.name)
        values.put(DbHelper.UserMail,e.mail)
        values.put(DbHelper.UserMdp,e.mdp)
        return db.insert(DbHelper.dbTableUser,null,values)
    }




}