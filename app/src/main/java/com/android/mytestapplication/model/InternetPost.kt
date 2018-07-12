package com.android.mytestapplication.model

import io.realm.RealmObject

/**
 * Model of RealmObject for InternetPost
 */
open class InternetPost : RealmObject() {

    /**
     * id use for identify entity in database
     */
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