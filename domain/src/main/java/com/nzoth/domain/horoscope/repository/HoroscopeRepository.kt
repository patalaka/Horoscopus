package com.nzoth.domain.horoscope.repository

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.horoscope.modal.Horoscope

interface HoroscopeRepository {
    fun getHoroscopeList(): Either<Failure, List<Horoscope>>
}