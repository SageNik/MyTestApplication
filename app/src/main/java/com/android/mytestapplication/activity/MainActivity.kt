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

/**
 * Activity for loading layout resources
 *
 * This is main activity is used to display main functionality of application
 */
class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener{

    /**
     * ViewPager use for display content from adapter
     */
    private var viewPager: ViewPager? = null
    /**
     * TabLayout use for display and manage tabs
     */
    private var tabLayout: TabLayout? = null

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

    // override behavior for several actions with tabs
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
