package com.nzoth.presentation.di

import com.nzoth.domain.horoscope.interactor.HoroscopeListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { HoroscopeListUseCase(get()) }
}