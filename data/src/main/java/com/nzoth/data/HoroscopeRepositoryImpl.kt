package com.nzoth.data

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.horoscope.HoroscopeType
import com.nzoth.domain.horoscope.model.Horoscope
import com.nzoth.domain.horoscope.repository.HoroscopeRepository
import com.nzoth.domain.zodiac.model.Zodiac

class HoroscopeRepositoryImpl : HoroscopeRepository {
    override fun getHoroscopeListByZodiac(zodiac: Zodiac): Either<Failure, List<Horoscope>> {
        var counter = 0
        for (i in 1..10000) {
            counter++
        }
        return Either.Right(mutableListOf(Horoscope(HoroscopeType.GENERAL,
                linkedMapOf(
                        Pair(1L, "test1"),
                        Pair(2L, "test2"),
                        Pair(3L, "test3")
                )
        )))
    }
}