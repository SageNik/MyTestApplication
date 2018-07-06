package com.android.mytestapplication.service.interfaces

import com.android.mytestapplication.model.InternetPost
import io.realm.RealmResults
import org.json.JSONArray

interface InternetPostService {
    fun findAllInternetPosts(): RealmResults<InternetPost>
    fun downloadInternetPostsFromServer(internetPosts: JSONArray): Boolean
}