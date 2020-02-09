package com.appiacare.androiddiabetescare.commons.database.entity

import com.sayhitoiot.realmdatabase.model.Person
import io.realm.Realm

data class PersonEntity (
    val id: Int,
    val name: String
) {

    constructor(userRealm: Person) : this(
        id = userRealm.id,
        name = userRealm.name
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
            name: String
        ) {
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()

            val userModel = realm.createObject(Person::class.java)

            userModel.id = id
            userModel.name = name

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