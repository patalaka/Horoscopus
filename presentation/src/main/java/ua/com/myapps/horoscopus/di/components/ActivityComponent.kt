package ua.com.myapps.horoscopus.di.components

import android.support.v7.app.AppCompatActivity
import dagger.Component
import ua.com.myapps.horoscopus.di.PerActivity
import ua.com.myapps.horoscopus.di.modules.ActivityModule

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): AppCompatActivity
}