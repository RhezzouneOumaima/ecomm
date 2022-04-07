package com.example.ecomm.Model
//pour la parties des comptes
class User (var name:String,var mail:String,var mdp:String) {
    var id:Int?=null
    constructor(id: Int?, name:String, mail:String, mdp:String) : this(name,mail,mdp) {
        this.name =name
        this.mail=mail
        this.mdp=mdp
    }
}