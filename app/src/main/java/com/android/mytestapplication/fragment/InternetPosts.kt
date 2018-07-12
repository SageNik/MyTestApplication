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
import android.widget.ProgressBar
import android.widget.Toast

import com.android.mytestapplication.R
import com.android.mytestapplication.activity.InternetPostActivity
import com.android.mytestapplication.adapter.InternetPostsAdapter
import com.android.mytestapplication.constants.Constants
import com.android.mytestapplication.model.InternetPost
import com.android.mytestapplication.service.impl.InternetPostServiceImpl
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

/**
 * Fragment for loading layout resources
 *
 * This is Fragment is used for load need data for view  of InternetPosts
 */
class InternetPosts : Fragment() {

    /**
     * InternetPostService use for apply service methods
     */
    private val internetPostService = InternetPostServiceImpl()
    /**
     * InternetPostView use for create current view
     */
    private var internetPostsView: View? = null
    /**
     * ListView  use for view list of InternetPost
     */
    private var listView: ListView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val context: Context? = container?.context
        internetPostsView = inflater.inflate(R.layout.my_posts, container, false)
        listView = internetPostsView?.findViewById<ListView>(R.id.list_posts)
        getAllInternetPosts()

        val fab = internetPostsView?.findViewById<FloatingActionButton>(R.id.fab)
        fab?.visibility = View.GONE

        val intent = Intent(context, InternetPostActivity::class.java)
        setItemListener(listView, intent)

       return internetPostsView
    }

    private fun getAllInternetPosts(){

        val progressBar = internetPostsView?.findViewById<ProgressBar>(R.id.progressBar)
        progressBar?.visibility = View.VISIBLE

        val stringRequest = JsonArrayRequest( Request.Method.GET, Constants.INTERNET_POSTS_SERVER_URL,null,
                Response.Listener<JSONArray> { response ->

                    if(internetPostService.downloadInternetPostsFromServer(response)){
                        val adapter= InternetPostsAdapter(context, internetPostService.findAllInternetPosts() )
                        listView?.adapter = adapter
                        progressBar?.visibility = View.INVISIBLE
                    }

                }, Response.ErrorListener {
            Toast.makeText(context, "Fault connect to server!", Toast.LENGTH_SHORT).show()
        })

        // add current query to request queue and apply it
        val requestQueue = Volley.newRequestQueue(context?.applicationContext)
        requestQueue.add(stringRequest)
        requestQueue.start()
    }

    private fun setItemListener(listView: ListView?, intent: Intent?) {
        listView?.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as InternetPost
            intent?.apply {
                //put parameters for the InternetPostActivity
                putExtra(Constants.SELECTED_POST_TITLE, selectedItem.getTitle())
                putExtra(Constants.SELECTED_POST_BODY, selectedItem.getBody())
                putExtra(Constants.SELECTED_POST_ID, selectedItem.getId().toString())
            }
            startActivity(intent)
        }
    }
}
