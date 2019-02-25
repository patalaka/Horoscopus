package ua.com.myapps.horoscopus.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : androidx.fragment.app.Fragment() {
    abstract val layout: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layout, container, false)
        onCreateView(view, savedInstanceState)
        return view
    }

    abstract fun onCreateView(view: View, savedInstanceState: Bundle?)
}