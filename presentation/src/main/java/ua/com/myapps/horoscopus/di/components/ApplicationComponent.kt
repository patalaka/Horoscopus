package ua.com.myapps.horoscopus.di.components

import android.content.Context
import dagger.Component
import ua.com.myapps.horoscopus.di.modules.ApplicationModule
import ua.com.myapps.horoscopus.view.activity.BaseActivity
import javax.inject.Singleton

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(baseActivity: BaseActivity)

    //Exposed to sub-graphs.
    fun context(): Context
}