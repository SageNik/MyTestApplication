package com.android.mytestapplication.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.android.mytestapplication.fragment.InternetPosts
import com.android.mytestapplication.fragment.MyPosts

class Pager(fm: FragmentManager, private val tabCount: Int) : FragmentStatePagerAdapter(fm) {

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
