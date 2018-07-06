package com.android.mytestapplication.repository.interfaces

import com.android.mytestapplication.model.InternetPost
import io.realm.RealmResults
import org.json.JSONArray

interface InternetPostRepository {

    fun saveAllFromServer(jsonObjects: JSONArray) : Boolean
    fun findAllInternetPosts() : RealmResults<InternetPost>
}