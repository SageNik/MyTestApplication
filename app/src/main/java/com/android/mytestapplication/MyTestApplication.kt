package com.android.mytestapplication

import android.app.Application

import io.realm.Realm
import io.realm.RealmConfiguration

class MyTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("myRealm.test1").build()
        Realm.deleteRealm(config)
        Realm.setDefaultConfiguration(config)
    }

}
