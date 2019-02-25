package com.nzoth.data.di

import com.nzoth.data.HoroscopeRepositoryImpl
import com.nzoth.data.ZodiacRepositoryImpl
import com.nzoth.domain.horoscope.repository.HoroscopeRepository
import com.nzoth.domain.zodiac.repository.ZodiacRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HoroscopeRepository> { HoroscopeRepositoryImpl() }
    single<ZodiacRepository> { ZodiacRepositoryImpl() }
}