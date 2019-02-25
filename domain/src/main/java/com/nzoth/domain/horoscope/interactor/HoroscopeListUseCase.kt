package com.nzoth.domain.horoscope.interactor

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.UseCase
import com.nzoth.domain.horoscope.model.Horoscope
import com.nzoth.domain.horoscope.repository.HoroscopeRepository

class HoroscopeListUseCase(
        private val repository: HoroscopeRepository
) : UseCase<List<Horoscope>, UseCase.None>() {
    override suspend fun run(params: None): Either<Failure, List<Horoscope>> = repository.getHoroscopeList()
}