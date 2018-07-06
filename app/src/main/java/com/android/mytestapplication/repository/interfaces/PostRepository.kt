package com.android.mytestapplication.repository.interfaces

import com.android.mytestapplication.model.Post
import io.realm.RealmResults
import org.json.JSONArray
import java.net.URL

interface PostRepository {

    fun findOneById(id: Long): Post?
    fun save(post: Post): Post?
    fun update(post: Post): Post?
    fun delete(post: Post)
    fun findAllMyPosts(): RealmResults<Post>

}