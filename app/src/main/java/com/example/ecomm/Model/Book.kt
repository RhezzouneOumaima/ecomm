package com.example.ecomm.Model
//class pour definir les livres ajoutés par l'utilisateur
class Book(var nom:String,var prix:String,var qte:String,var img:Int) {
    var id:Int?=null
    constructor(id:Int,nom:String,prix:String,qte:String,img:Int) : this(nom,prix,qte,img) {
        this.nom =nom
        this.prix=prix
        this.qte=qte
        this.img=img
    }
}