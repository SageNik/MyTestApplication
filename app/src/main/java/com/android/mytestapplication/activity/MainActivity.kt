package com.android.mytestapplication.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.android.mytestapplication.adapter.Pager
import com.android.mytestapplication.R
import com.android.mytestapplication.constants.Constants.INTERNET_POSTS_SERVER_URL
import com.android.mytestapplication.service.impl.PostServiceImpl

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener{

    private var viewPager: ViewPager? = null
    private var tabLayout: TabLayout? = null
    private var postService = PostServiceImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabs)
        tabLayout?.addTab(tabLayout?.newTab()?.setText(R.string.tab_text_1)!!)
        tabLayout?.addTab(tabLayout?.newTab()?.setText(R.string.tab_text_2)!!)
        tabLayout?.tabGravity = TabLayout.GRAVITY_FILL
        tabLayout?.addOnTabSelectedListener(this)

        val adapter = Pager(supportFragmentManager, tabLayout?.tabCount!!)
        viewPager = findViewById(R.id.pager)
        viewPager?.adapter = adapter

        val toolbar: Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
    }
        override fun onTabReselected(tab: TabLayout.Tab?) {
            viewPager?.currentItem = tab?.position!!
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {
            viewPager?.currentItem = tab?.position!!
        }

        override fun onTabSelected(tab: TabLayout.Tab?) {
            viewPager?.currentItem = tab?.position!!
        }

}
