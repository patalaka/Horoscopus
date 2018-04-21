package ua.com.myapps.horoscopus.view.fragment

import android.os.Bundle
import android.view.View
import ua.com.myapps.horoscopus.R

class TabHoroscopeFragment : BaseFragment() {
    override val layout: Int = R.layout.fragment_tab_horoscope

    companion object {
        fun newInstance() = TabHoroscopeFragment()
    }

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {

    }
}