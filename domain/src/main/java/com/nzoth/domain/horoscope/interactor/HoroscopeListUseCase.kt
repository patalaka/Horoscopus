package com.nzoth.domain.horoscope.interactor

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.UseCase
import com.nzoth.domain.horoscope.model.Horoscope
import com.nzoth.domain.horoscope.repository.HoroscopeRepository
import com.nzoth.domain.zodiac.model.Zodiac

class HoroscopeListUseCase(
        private val repository: HoroscopeRepository
) : UseCase<List<Horoscope>, HoroscopeListUseCase.Params>() {

    override suspend fun run(params: Params): Either<Failure, List<Horoscope>> =
            repository.getHoroscopeListByZodiac(params.zodiac)

    data class Params(val zodiac: Zodiac)
}