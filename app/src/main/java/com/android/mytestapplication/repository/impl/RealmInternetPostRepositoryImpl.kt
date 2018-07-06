package com.android.mytestapplication.repository.impl

import com.android.mytestapplication.model.InternetPost
import com.android.mytestapplication.repository.interfaces.InternetPostRepository
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import io.realm.kotlin.where
import org.json.JSONArray

class RealmInternetPostRepositoryImpl: InternetPostRepository {

    var realm = Realm.getDefaultInstance()


    override fun saveAllFromServer(jsonObjects: JSONArray): Boolean {
        var isSaved = false
        realm.executeTransaction { realm ->
            realm.createAllFromJson(InternetPost::class.java, jsonObjects)
            isSaved = true
        }
        return isSaved
    }

    override fun findAllInternetPosts(): RealmResults<InternetPost> {
        return realm.where<InternetPost>().findAll().sort("id", Sort.DESCENDING)
    }
}