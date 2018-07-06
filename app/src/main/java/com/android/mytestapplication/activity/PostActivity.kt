package com.android.mytestapplication.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.android.mytestapplication.R
import com.android.mytestapplication.constants.Constants
import com.android.mytestapplication.model.Post
import com.android.mytestapplication.service.impl.PostServiceImpl
import com.android.mytestapplication.service.interfaces.PostService

class PostActivity : AppCompatActivity() {

    var postService : PostService = PostServiceImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val postTitle = intent.getStringExtra(Constants.SELECTED_POST_TITLE)
        val postBody = intent.getStringExtra(Constants.SELECTED_POST_BODY)
        val postId = intent.getStringExtra(Constants.SELECTED_POST_ID)

        val postTitleView = findViewById<TextView>(R.id.inputTitle).apply{ text = postTitle}
        val postBodyView = findViewById<TextView>(R.id.inputBody).apply{ text = postBody}
        val postIdView = findViewById<TextView>(R.id.inputId).apply{ text = postId}

        val intentMain = Intent(this, MainActivity::class.java)
        val btnSave = findViewById<Button>(R.id.btnSavePost)
        val btnDelete = findViewById<Button>(R.id.btnDeletePost)
        if("" == postIdView.text.toString()) btnDelete.visibility = View.INVISIBLE

        btnSave.setOnClickListener{
           val currentPost = buildCurrentPost(postTitleView, postBodyView, postIdView)
            postService.createOrEditPost(currentPost)
            startActivity(intentMain)
        }


        btnDelete.setOnClickListener{
            val currentPostId = postIdView.text.toString().toLong()
            postService.deletePostById(currentPostId)
            startActivity(intentMain)
        }
    }

    private fun buildCurrentPost(postTitleView: TextView, postBodyView: TextView, postIdView: TextView): Post {
        val currentPost = Post()
        currentPost.setTitle(postTitleView.text.toString())
        currentPost.setBody(postBodyView.text.toString())
        if("" != postIdView.text.toString()) currentPost.setId(postIdView.text.toString().toLong())
        return currentPost
    }
}
