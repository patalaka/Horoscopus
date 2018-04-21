package ua.com.myapps.horoscopus.di.modules

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import ua.com.myapps.horoscopus.di.PerActivity

/**
 * A module to wrap the Activity state and expose it to the graph.
 */

@Module
class ActivityModule(private val activity: AppCompatActivity) {
    @Provides
    @PerActivity
    fun provideActivity()= activity
}