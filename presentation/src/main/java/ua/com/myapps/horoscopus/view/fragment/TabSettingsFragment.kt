package ua.com.myapps.horoscopus.view.fragment

import android.os.Bundle
import android.view.View
import ua.com.myapps.horoscopus.R

class TabSettingsFragment:BaseFragment() {
    override val layout: Int = R.layout.fragment_tab_settings

    companion object {
        fun newInstance() = TabSettingsFragment()
    }

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {

    }
}