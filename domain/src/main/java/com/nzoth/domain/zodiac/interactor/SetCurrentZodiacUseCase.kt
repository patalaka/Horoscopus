package com.nzoth.domain.zodiac.interactor

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.UseCase
import com.nzoth.domain.zodiac.model.Zodiac
import com.nzoth.domain.zodiac.repository.ZodiacRepository

class SetCurrentZodiacUseCase(
        private val zodiacRepository: ZodiacRepository
) : UseCase<UseCase.None, SetCurrentZodiacUseCase.Params>() {

    override suspend fun run(params: Params): Either<Failure, None> = zodiacRepository.setCurrentZodiac(params.zodiac)

    data class Params(val zodiac: Zodiac)
}