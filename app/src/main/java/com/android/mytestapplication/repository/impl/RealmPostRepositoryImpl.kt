package com.android.mytestapplication.repository.impl

import com.android.mytestapplication.model.Post
import com.android.mytestapplication.repository.interfaces.PostRepository
import io.realm.Realm
import io.realm.RealmResults
import io.realm.Sort
import io.realm.kotlin.where

class RealmPostRepositoryImpl : PostRepository{

    val realm: Realm = Realm.getDefaultInstance()

    override fun findAllMyPosts(): RealmResults<Post> {
        return realm.where<Post>().findAll().sort("id",Sort.DESCENDING)
    }

    override fun findOneById(id: Long): Post? {
        return realm.where<Post>().equalTo("id", id).findFirst()
    }

    override fun save(post: Post): Post? {
        var savedPost: Post? = null
        realm.executeTransaction{realm ->
            val maxId: Number? = realm.where<Post>().max("id")
            var nextId: Long = 1
            if(maxId != null) nextId = 1+ maxId.toLong()
            post.setId(nextId)
            savedPost = realm.copyToRealmOrUpdate(post) }
        return savedPost
    }

    override fun update(post: Post): Post? {
        var updatedPost: Post? = null
        realm.executeTransaction { realm -> updatedPost = realm.copyToRealmOrUpdate(post) }
        return updatedPost
    }
    override fun delete(post: Post) {
        realm.executeTransaction{realm ->  post.deleteFromRealm()}
    }
}