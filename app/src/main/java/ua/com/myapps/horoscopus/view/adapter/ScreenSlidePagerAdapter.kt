package ua.com.myapps.horoscopus.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ua.com.myapps.horoscopus.view.TabType

class ScreenSlidePagerAdapter(
        fragmentManager: androidx.fragment.app.FragmentManager,
        private val listener: SwipeListener
) : androidx.fragment.app.FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = listener.getFragmentByPosition(position)
    override fun getCount() = TabType.values().size

    interface SwipeListener {
        fun getFragmentByPosition(position: Int): androidx.fragment.app.Fragment
    }
}