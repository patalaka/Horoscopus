package ua.com.myapps.horoscopus.view.activity

import android.app.Fragment
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import ua.com.myapps.horoscopus.HoroscopusApplication
import ua.com.myapps.horoscopus.di.modules.ActivityModule
import ua.com.myapps.horoscopus.navigation.Navigator
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {
    @Inject lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getApplicationComponent().inject(this)
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    open fun addFragment(containerViewId: Int, fragment: Fragment) = fragmentManager
            .beginTransaction()
            .add(containerViewId, fragment)
            .commit()

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    open fun getApplicationComponent() = (application as HoroscopusApplication).getApplicationComponent()

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link ActivityModule}
     */
    open fun getActivityModule() = ActivityModule(this)
}