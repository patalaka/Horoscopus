package com.nzoth.presentation.features.host

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.nzoth.presentation.R
import com.nzoth.presentation.core.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_host.*

class HostActivity : BaseActivity() {
    private val navController: NavController by lazy { Navigation.findNavController(this, R.id.navigationHostView) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            navController.navigate(it.itemId)
            true
        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}