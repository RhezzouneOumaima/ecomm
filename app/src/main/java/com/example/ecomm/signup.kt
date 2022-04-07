package com.example.ecomm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ecomm.Model.Book
import com.example.ecomm.Model.BookDao
import com.example.ecomm.Model.User
import com.example.ecomm.Model.UserDao
import kotlinx.android.synthetic.main.activity_show_details.*
import kotlinx.android.synthetic.main.activity_show_details.ajouter
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        var dao= UserDao(this)
        registre.setOnClickListener {
            //ajouter les champs saisies dans la BD
  if(name.text.isEmpty() || mail.text.isEmpty() || mdp.text.isEmpty())
  {
      Toast.makeText(applicationContext,"Vous devez remplir tous les champs", Toast.LENGTH_SHORT).show()

  }
            else{
            var e= User(name.text.toString(),mail.text.toString(),mdp.text.toString())
            var test= dao.ajoutUser(e)
            if (test==-1.toLong())
                Toast.makeText(applicationContext,"un problem est survenu", Toast.LENGTH_SHORT).show()
            else {
                var i= Intent(this,home::class.java)
                startActivity(i)

            }

        }}
    }
}