package com.appiacare.androiddiabetescare.commons.database.entity

import com.sayhitoiot.realmdatabase.model.Person
import io.realm.Realm

data class PersonEntity (
    val id: Int,
    val name: String,
    var birthday: String,
    var email: String,
    var celular: String,
    var fixo: String,
    var state: String
) {

    constructor(userRealm: Person) : this(
        id = userRealm.id,
        name = userRealm.name,
        birthday = userRealm.birthday,
        email = userRealm.email,
        celular = userRealm.celular,
        fixo = userRealm.fixo,
        state = userRealm.state
    )

    companion object {

        fun getUser() : PersonEntity? {
            val realm = Realm.getDefaultInstance()

            val personModel = realm.where(Person::class.java)
                .findFirst()

            var personEntity: PersonEntity? = null

            if (personModel != null) {
                personEntity = PersonEntity(personModel)
            }

            realm.close()

            return personEntity
        }

        fun create(
            id: Int,
            name: String,
            birthday: String,
            email: String,
            celular: String,
            fixo: String,
            state: String
        ) {
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()

            val userModel = realm.createObject(Person::class.java)

            userModel.id = id
            userModel.name = name
            userModel.birthday = birthday
            userModel.email = email
            userModel.celular = celular
            userModel.fixo = fixo
            userModel.state = state

            realm.commitTransaction()
            realm.close()
        }

        fun delete() {
            val realm = Realm.getDefaultInstance()

            realm.beginTransaction()

            realm.delete(Person::class.java)

            realm.commitTransaction()
            realm.close()
        }
        fun update(
            name: String? = null,
            id: Int? = null
        ) {
            val realm = Realm.getDefaultInstance()

            realm.beginTransaction()

            val userModel = realm.where(Person::class.java)
                .equalTo("id", id)
                .findFirst()

            userModel?.name = name ?: name!!
            userModel?.id = id ?: id!!

            realm.commitTransaction()
            realm.close()
        }
    }



    fun removeDeviceNome() {
        val realm = Realm.getDefaultInstance()

        realm.beginTransaction()

        val userModel = realm.where(Person::class.java)
            .equalTo("id", this.id)
            .findFirst()

        userModel?.name = null.toString()

        realm.commitTransaction()
        realm.close()
    }
}