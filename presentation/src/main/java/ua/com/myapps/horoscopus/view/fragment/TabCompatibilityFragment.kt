package ua.com.myapps.horoscopus.view.fragment

import android.os.Bundle
import android.view.View
import ua.com.myapps.horoscopus.R

class TabCompatibilityFragment : BaseFragment() {
    override val layout: Int = R.layout.fragment_tab_compatibility

    companion object {
        fun newInstance() = TabCompatibilityFragment()
    }

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {

    }
}