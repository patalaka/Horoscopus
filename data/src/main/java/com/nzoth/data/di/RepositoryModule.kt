package com.nzoth.data.di

import com.nzoth.data.TestRepository
import com.nzoth.domain.horoscope.repository.HoroscopeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HoroscopeRepository> { TestRepository() }
}