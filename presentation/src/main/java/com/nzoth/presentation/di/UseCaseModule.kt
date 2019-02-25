package com.nzoth.presentation.di

import com.nzoth.domain.horoscope.interactor.HoroscopeListUseCase
import com.nzoth.domain.zodiac.interactor.GetCurrentZodiacUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { HoroscopeListUseCase(get()) }
    single { GetCurrentZodiacUseCase(get()) }
}