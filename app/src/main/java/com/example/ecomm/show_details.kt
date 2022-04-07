package com.example.ecomm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ecomm.Model.Book
import com.example.ecomm.Model.BookDao
import kotlinx.android.synthetic.main.activity_show_details.*

class show_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)
        var c=intent.getSerializableExtra("book") as Product
        nom.text=c.nom
        prix.text=c.prix
        foodPic.setImageResource(c.image)
        //pour choisir une quantité entre 1 et un chiffre
         plusBtn.setOnClickListener {
             var nb=Integer.parseInt(numberOrderTxt.text.toString())
             nb++
             numberOrderTxt.text=nb.toString()
         }
        minusBtn.setOnClickListener {
            var nb=Integer.parseInt(numberOrderTxt.text.toString())
            nb--
            if(nb<1)
                Toast.makeText(this,"la quantité ne peut pas etre inferieure a 1",Toast.LENGTH_LONG).show()
            else
            numberOrderTxt.text=nb.toString()

        }
        var dao= BookDao(this)
        //ajouter le livre dans la table Book
        ajouter.setOnClickListener {

                var e=Book(nom.text.toString(),prix.text.toString(),numberOrderTxt.text.toString(),c.image)
                var test= dao.ajoutBook(e)
                if (test==-1.toLong())
                    Toast.makeText(applicationContext,"un problem est survenu",Toast.LENGTH_SHORT).show()
                else {                Toast.makeText(applicationContext,"bien inserer",Toast.LENGTH_SHORT).show()

                }

        }

    }
}