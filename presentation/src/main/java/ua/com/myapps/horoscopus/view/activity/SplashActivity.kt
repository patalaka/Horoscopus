package ua.com.myapps.horoscopus.view.activity

import android.os.Bundle

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.navigateToTabsScreen()
        finish()
    }
}