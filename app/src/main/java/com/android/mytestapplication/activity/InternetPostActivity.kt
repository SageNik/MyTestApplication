package com.android.mytestapplication.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.mytestapplication.R
import com.android.mytestapplication.constants.Constants

class InternetPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet_post)

        val postTitle = intent.getStringExtra(Constants.SELECTED_POST_TITLE)
        val postBody = intent.getStringExtra(Constants.SELECTED_POST_BODY)
        val postId = intent.getStringExtra(Constants.SELECTED_POST_ID)

        findViewById<TextView>(R.id.inputInternetTitle).apply{ text = postTitle}
        findViewById<TextView>(R.id.inputInternetBody).apply{ text = postBody}
        findViewById<TextView>(R.id.inputInternetId).apply{ text = postId}
    }
}
