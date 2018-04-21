package ua.com.myapps.horoscopus.view.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ua.com.myapps.horoscopus.view.TabType

class ScreenSlidePagerAdapter(
        fragmentManager: FragmentManager,
        private val listener: SwipeListener
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = listener.getFragmentByPosition(position)
    override fun getCount() = TabType.values().size

    interface SwipeListener {
        fun getFragmentByPosition(position: Int): Fragment
    }
}