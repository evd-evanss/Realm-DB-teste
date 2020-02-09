package com.sayhitoiot.realmdatabase

import android.app.Application
import com.sayhitoiot.realmdatabase.model.RealmDB
import io.realm.Realm
import io.realm.RealmConfiguration

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        configureDatabase()
    }

    private fun configureDatabase() {
        RealmDB.configureRealm(this)
    }
}