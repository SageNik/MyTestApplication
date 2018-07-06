package com.android.mytestapplication.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.android.mytestapplication.R
import com.android.mytestapplication.activity.PostActivity
import com.android.mytestapplication.adapter.PostsAdapter
import com.android.mytestapplication.constants.Constants
import com.android.mytestapplication.model.Post
import com.android.mytestapplication.service.impl.PostServiceImpl
import com.android.mytestapplication.service.interfaces.PostService

class MyPosts : Fragment(), Constants {

    private var postService: PostService = PostServiceImpl()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val context: Context? = container?.context
        val adapter = PostsAdapter(context, postService.findAllMyPosts())
        val myPostsView = inflater.inflate(R.layout.my_posts, container, false)
        val listView = myPostsView.findViewById<ListView>(R.id.list_posts)
        val fab = myPostsView.findViewById<FloatingActionButton>(R.id.fab)
        listView.adapter = adapter
        val intent = Intent(context, PostActivity::class.java)

        setItemListener(listView, intent)

        setFabOnClickListener(fab, intent)

        return myPostsView
    }

    private fun setFabOnClickListener(fab: FloatingActionButton, intent: Intent) {
        fab.setOnClickListener { view ->
            intent?.apply {
                putExtra(Constants.SELECTED_POST_TITLE, "")
                putExtra(Constants.SELECTED_POST_BODY, "")
                putExtra(Constants.SELECTED_POST_ID, "")
            }
            startActivity(intent)
        }
    }

    private fun setItemListener(listView: ListView?, intent: Intent?) {
        listView?.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as Post
            intent?.apply {
                putExtra(Constants.SELECTED_POST_TITLE, selectedItem.getTitle())
                putExtra(Constants.SELECTED_POST_BODY, selectedItem.getBody())
                putExtra(Constants.SELECTED_POST_ID, selectedItem.getId().toString())
            }
            startActivity(intent)
        }
    }
}
