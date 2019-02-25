package ua.com.myapps.horoscopus

import android.app.Application
import com.nzoth.data.di.repositoryModule
import com.nzoth.presentation.di.appModule
import com.nzoth.presentation.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HoroscopusApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(appModule, repositoryModule, useCaseModule))

            logger()
            androidContext(this@HoroscopusApp)
        }
    }
}