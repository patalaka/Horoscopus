package com.nzoth.domain.zodiac.interactor

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.UseCase
import com.nzoth.domain.zodiac.model.Zodiac
import com.nzoth.domain.zodiac.repository.ZodiacRepository

class GetCurrentZodiacUseCase(
        private val zodiacRepository: ZodiacRepository
) : UseCase<Zodiac, UseCase.None>() {

    override suspend fun run(params: UseCase.None): Either<Failure, Zodiac> = zodiacRepository.getCurrentZodiac()

}