package com.example.ecomm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class home : AppCompatActivity() {
    lateinit var listView: ListView
    var arrayList: ArrayList<Product> = ArrayList()
    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//Création une arraylist pour les livres disponibles avec Custom Adapter
        listView = findViewById(R.id.books)
        arrayList.add(Product(R.drawable.book1,"Afterparties", "30$"))
        arrayList.add(Product(R.drawable.book2,"Beautiful World, Where Are You", "42$"))
        arrayList.add(Product(R.drawable.book6,"Fiona and Jane", "14$"))

        arrayList.add(Product(R.drawable.book4,"The School For Good Mother", "25$"))
        arrayList.add(Product(R.drawable.book5,"Bridge of Sighs", "32$"))
        arrayList.add(Product(R.drawable.book3,"Milk Fed", "20$"))
        adapter = MyAdapter(this, arrayList)
        listView.adapter = adapter

      books.setOnItemClickListener { parent, view, position, id ->
          var i= Intent(this,show_details::class.java)
          i.putExtra("book",arrayList[position])
          startActivity(i)
          //pour envoyer les données de chaque livre de la liste
      }
        card_btn.setOnClickListener {
           //pour l'affichage des livres ajoutés dans le panier
                var i= Intent(this,panier::class.java)
                startActivity(i)

        }
    }
}



//Class MyAdapter
class MyAdapter(private val context: Context, private val arrayList: java.util.ArrayList<Product>) : BaseAdapter() {
    private lateinit var image: ImageView
    private lateinit var name: TextView
    private lateinit var Prix: TextView
    override fun getCount(): Int {
        return arrayList.size
    }
    override fun getItem(position: Int): Any {
        return position
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.product, parent, false)
        image = convertView.findViewById(R.id.imageView)
        name = convertView.findViewById(R.id.Nom)
        Prix = convertView.findViewById(R.id.Prix)
        image.setImageDrawable(context.resources.getDrawable(arrayList[position].image))
        name.text = arrayList[position].nom
        Prix.text = arrayList[position].prix.toString()+" "
        return convertView
    }
}