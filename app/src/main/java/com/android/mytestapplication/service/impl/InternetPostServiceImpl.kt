package com.android.mytestapplication.service.impl

import com.android.mytestapplication.model.InternetPost
import com.android.mytestapplication.repository.impl.RealmInternetPostRepositoryImpl
import com.android.mytestapplication.service.interfaces.InternetPostService
import io.realm.RealmResults
import org.json.JSONArray

class InternetPostServiceImpl: InternetPostService {

    var internetPostRepository = RealmInternetPostRepositoryImpl()

    override fun downloadInternetPostsFromServer(internetPosts: JSONArray): Boolean {
        return internetPostRepository.saveAllFromServer(internetPosts)
    }

    override fun findAllInternetPosts(): RealmResults<InternetPost> {
        return internetPostRepository.findAllInternetPosts()
    }
}