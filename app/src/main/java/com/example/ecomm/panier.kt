package com.example.ecomm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ecomm.Model.Book
import com.example.ecomm.Model.BookDao
import kotlinx.android.synthetic.main.activity_panier.*

class panier : AppCompatActivity() {
   var Books:ArrayList<Book> =ArrayList()
    var adapter2: MyAdapter2? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panier)
        var dao= BookDao(this)
        var list=dao.getAll()
        adapter2 = MyAdapter2(this, Books)
        listP.adapter = adapter2
        //accéder a la table Book pour récepurer les livres de panier
        for(i in list)
        {
            Books.add(Book(i.nom,i.prix,i.qte,i.img))
            adapter2!!.notifyDataSetChanged()

        }
        delete.setOnClickListener {
            dao.deleteAll()
            Books.clear()
            adapter2!!.notifyDataSetChanged()
        }
    }
}
//Class MyAdapter
class MyAdapter2(private val context: Context, private val arrayList: java.util.ArrayList<Book>) : BaseAdapter() {
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
        image.setImageDrawable(context.resources.getDrawable(arrayList[position].img))
        name.text = arrayList[position].nom
        Prix.text = arrayList[position].prix.toString()+" Quantite de "+arrayList[position].qte
        return convertView
    }
}