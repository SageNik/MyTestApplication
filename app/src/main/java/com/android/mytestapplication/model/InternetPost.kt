package com.android.mytestapplication.model

import io.realm.RealmObject

open class InternetPost : RealmObject() {

    private var id: Long? = null
    private var title: String? = null
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