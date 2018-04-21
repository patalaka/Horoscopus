package ua.com.myapps.horoscopus

import android.app.Application
import ua.com.myapps.horoscopus.di.components.ApplicationComponent
import ua.com.myapps.horoscopus.di.components.DaggerApplicationComponent
import ua.com.myapps.horoscopus.di.modules.ApplicationModule

class HoroscopusApplication:Application() {
    companion object{
        @JvmStatic lateinit var appComponent:ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(applicationContext))
                .build()
    }

    fun getApplicationComponent() = appComponent
}