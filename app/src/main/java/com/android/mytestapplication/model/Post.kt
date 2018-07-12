package com.android.mytestapplication.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
/**
 * Model of RealmObject for Post
 */
open  class Post : RealmObject() {

    /**
     * id use for identify entity in database
     */
    @PrimaryKey
    private var id: Long? = null
    /**
     * title use for title post
     */
    private var title: String? = null
    /**
     * body use for content of post
     */
    private var body: String? = ""

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getBody(): String? {
        return body
    }

    fun setBody(body: String?) {
        this.body = body
    }
}