package com.nzoth.presentation.di

import com.nzoth.presentation.features.horoscope.list.HoroscopeListContract
import com.nzoth.presentation.features.horoscope.list.HoroscopeListFragment
import com.nzoth.presentation.features.horoscope.list.HoroscopeListPresenter
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    factory<HoroscopeListContract.Presenter> { (fragment: HoroscopeListFragment) ->
        HoroscopeListPresenter(fragment, get(), get())
    }
}