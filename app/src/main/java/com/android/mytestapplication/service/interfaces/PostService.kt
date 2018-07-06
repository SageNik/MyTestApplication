package com.android.mytestapplication.service.interfaces

import com.android.mytestapplication.model.Post
import io.realm.RealmResults

interface PostService {

    fun findPostById(id: Long): Post?
    fun createOrEditPost(post: Post): Boolean
    fun deletePostById(id: Long): Boolean
    fun findAllMyPosts(): RealmResults<Post>
}