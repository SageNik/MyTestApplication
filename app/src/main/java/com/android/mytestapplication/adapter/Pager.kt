package com.android.mytestapplication.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.android.mytestapplication.fragment.InternetPosts
import com.android.mytestapplication.fragment.MyPosts

/**
 * Adapter for preparing data for view
 *
 * This is adapter is used for get right Fragment for view
 */
class Pager(fm: FragmentManager, tabCount: Int) : FragmentStatePagerAdapter(fm) {

    /**
     * Int tab count use for store current tab count
     */
    private val tabCount = tabCount

    override fun getItem(position: Int): Fragment {

        val fragment: Fragment
        if (position == 0)
            fragment = MyPosts()
        else
            fragment = InternetPosts()
        return fragment
    }

    override fun getCount(): Int {
        return tabCount
    }
}
