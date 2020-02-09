package com.sayhitoiot.realmdatabase.model

import io.realm.RealmObject

open class Person: RealmObject(){
    var name: String = ""
    var id: Int = 0
    var birthday: String = ""
    var email: String = ""
    var celular: String = ""
    var fixo: String = ""
    var state: String = ""
}