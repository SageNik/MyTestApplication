package com.android.mytestapplication.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.android.mytestapplication.R
import com.android.mytestapplication.model.Post
import io.realm.RealmResults

/**
 * Adapter for preparing data for view
 *
 * This is adapter is used for view Post data
 */
class PostsAdapter(context: Context?, posts: RealmResults<Post>) : ArrayAdapter<Post>(context,R.layout.row, posts) {

    /**
     * ArrayAdapter<Post>  use for store Post models
     */
    internal val posts = posts
    /**
     * Context this is a context application
     */
    internal var context = context

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

         val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
         val rowView = inflater.inflate(R.layout.row, parent, false)
         val postTitleView = rowView.findViewById<View>(R.id.textPostTitle) as TextView
         val postContentView = rowView.findViewById<TextView>(R.id.textPostContent)
         val postIdView = rowView.findViewById<TextView>(R.id.textPostId)

        // set values to fields
        postTitleView.text = posts[position]?.getTitle()
        postContentView.text = posts[position]?.getBody()
        postIdView.text = posts[position]?.getId().toString()

         return rowView
    }


}