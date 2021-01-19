package com.example.dataclassroomstorage.Model

class User1 {
    var id : String = ""
    var sid : String = ""
    var name : String = ""
    var adr : String = ""

    constructor(id:String,sid:String,name:String,adr:String){
        this.id = id
        this.sid = sid
        this.name = name
        this.adr = adr
    }

    constructor(){
    }
}