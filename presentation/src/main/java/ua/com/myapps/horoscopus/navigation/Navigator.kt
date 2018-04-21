package ua.com.myapps.horoscopus.navigation

import android.content.Context
import android.content.Intent
import ua.com.myapps.horoscopus.view.activity.TabsActivity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Class used to navigate through the application.
 */
@Singleton
class Navigator @Inject constructor(val context: Context) {
    fun navigateToTabsScreen() = with(context) {
        startActivity(Intent(this, TabsActivity::class.java))
    }
}