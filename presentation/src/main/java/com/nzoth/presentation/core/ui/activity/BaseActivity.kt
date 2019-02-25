package com.nzoth.presentation.core.ui.activity

import android.app.Fragment
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    open fun addFragment(containerViewId: Int, fragment: Fragment) = fragmentManager
            .beginTransaction()
            .add(containerViewId, fragment)
            .commit()
}