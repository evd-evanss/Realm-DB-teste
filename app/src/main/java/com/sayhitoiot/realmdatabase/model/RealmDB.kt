package com.sayhitoiot.realmdatabase.model

import android.content.Context
import com.appiacare.androiddiabetescare.commons.database.entity.PersonEntity
import io.realm.Realm
import io.realm.RealmConfiguration



object RealmDB {

    const val DEFAULT_INTEGER = 0

    fun configureRealm(context: Context) {
        Realm.init(context)

        val mRealmConfiguration = RealmConfiguration.Builder()
            .name("myrealm.realm")
            .schemaVersion(0)
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.getInstance(mRealmConfiguration)
        Realm.setDefaultConfiguration(mRealmConfiguration)
    }

    fun clearDatabase() {
        PersonEntity.delete()
    }

}