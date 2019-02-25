package com.nzoth.domain.horoscope.repository

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.horoscope.model.Horoscope
import com.nzoth.domain.zodiac.model.Zodiac

interface HoroscopeRepository {
    fun getHoroscopeListByZodiac(zodiac: Zodiac): Either<Failure, List<Horoscope>>
}