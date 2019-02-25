package com.nzoth.domain.zodiac.repository

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.UseCase
import com.nzoth.domain.zodiac.model.Zodiac

interface ZodiacRepository {
    fun getZodiacList(): Either<Failure, List<Zodiac>>

    fun getCurrentZodiac(): Either<Failure, Zodiac>

    fun setCurrentZodiac(zodiac: Zodiac): Either<Failure, UseCase.None>
}