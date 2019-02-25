package ua.com.myapps.horoscopus.view.activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.MenuItem
import ua.com.myapps.horoscopus.R
import ua.com.myapps.horoscopus.view.TabType
import ua.com.myapps.horoscopus.view.adapter.ScreenSlidePagerAdapter
import ua.com.myapps.horoscopus.view.fragment.TabCompatibilityFragment
import ua.com.myapps.horoscopus.view.fragment.TabHoroscopeFragment
import ua.com.myapps.horoscopus.view.fragment.TabSettingsFragment
import ua.com.myapps.horoscopus.view.fragment.TextFragment

class TabsActivity {
//    private val tabHoroscopeFragment = TabHoroscopeFragment.newInstance()
//    private val tabCompatibilityFragment = TabCompatibilityFragment.newInstance()
//    private val tabSettingsFragment = TabSettingsFragment.newInstance()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_tabs)
//        initViews()
//    }
//
//    override fun getFragmentByPosition(position: Int) = when (position) {
//        TabType.HOROSCOPES.ordinal -> tabHoroscopeFragment
//        TabType.COMPATIBILITY.ordinal -> tabCompatibilityFragment
//        TabType.SETTINGS.ordinal -> tabSettingsFragment
//        else -> TextFragment.newInstance(R.string.something_wrong)
//    }
//
//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        viewPagerView.currentItem = when (item.itemId) {
//            R.id.horoscopes -> TabType.HOROSCOPES.ordinal
//            R.id.compatibility -> TabType.COMPATIBILITY.ordinal
//            R.id.settings -> TabType.SETTINGS.ordinal
//            else -> TabType.HOROSCOPES.ordinal
//        }
//        return true
//    }
//
//    private fun initViews() {
//        viewPagerView.swipeable = false
//        viewPagerView.offscreenPageLimit = TabType.values().size
//        viewPagerView.adapter = ScreenSlidePagerAdapter(supportFragmentManager, this)
//        bottomMenuView.setOnNavigationItemSelectedListener(this)
//        bottomMenuView.selectedItemId = R.id.horoscopes
//    }
}