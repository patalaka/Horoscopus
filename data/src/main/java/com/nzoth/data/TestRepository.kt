package com.nzoth.data

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.horoscope.modal.Horoscope
import com.nzoth.domain.horoscope.repository.HoroscopeRepository

class TestRepository : HoroscopeRepository {
    override fun getHoroscopeList(): Either<Failure, List<Horoscope>> {
        var counter = 0
        for(i in 1..10000){
            counter++
        }
        return Either.Right(mutableListOf(Horoscope(counter.toString()), Horoscope("3"), Horoscope("2")))
    }
}