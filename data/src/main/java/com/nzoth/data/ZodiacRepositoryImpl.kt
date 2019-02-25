package com.nzoth.data

import com.nzoth.domain.Either
import com.nzoth.domain.Failure
import com.nzoth.domain.UseCase
import com.nzoth.domain.zodiac.ZodiacType
import com.nzoth.domain.zodiac.model.Zodiac
import com.nzoth.domain.zodiac.repository.ZodiacRepository

class ZodiacRepositoryImpl : ZodiacRepository {
    override fun getZodiacList(): Either<Failure, List<Zodiac>> {
        return Either.Right(listOf())
    }

    override fun getCurrentZodiac(): Either<Failure, Zodiac> {
        return Either.Right(createZodiacByType(ZodiacType.ARIES))
    }

    override fun setCurrentZodiac(zodiac: Zodiac): Either<Failure, UseCase.None> {
        return Either.Left(Failure.ServerError)
    }

    private fun createZodiacByType(zodiacType: ZodiacType): Zodiac {
        val bigIcon: Int
        val smallIcon: Int
        val name: Int
        val date: Int
        val slogan: Int

        when (zodiacType) {
            ZodiacType.ARIES -> {
                bigIcon = R.drawable.ic_z_big_aries
                smallIcon = R.drawable.ic_z_small_aquarius
                name = R.string.aries
                date = R.string.date_aries
                slogan = R.string.status_aries
            }
            ZodiacType.TAURUS -> {
                bigIcon = R.drawable.ic_z_big_taurus
                smallIcon = R.drawable.ic_z_small_taurus
                name = R.string.taurus
                date = R.string.date_taurus
                slogan = R.string.status_taurus
            }
            ZodiacType.GEMINI -> {
                bigIcon = R.drawable.ic_z_big_gemini
                smallIcon = R.drawable.ic_z_small_gemini
                name = R.string.gemini
                date = R.string.date_gemini
                slogan = R.string.status_gemini
            }
            ZodiacType.CANCER -> {
                bigIcon = R.drawable.ic_z_big_cancer
                smallIcon = R.drawable.ic_z_small_cancer
                name = R.string.cancer
                date = R.string.date_cancer
                slogan = R.string.status_cancer
            }
            ZodiacType.LEO -> {
                bigIcon = R.drawable.ic_z_big_leo
                smallIcon = R.drawable.ic_z_small_leo
                name = R.string.leo
                date = R.string.date_leo
                slogan = R.string.status_leo
            }
            ZodiacType.VIRGO -> {
                bigIcon = R.drawable.ic_z_big_virgo
                smallIcon = R.drawable.ic_z_small_virgo
                name = R.string.leo
                date = R.string.date_leo
                slogan = R.string.status_leo
            }
            ZodiacType.LIBRA -> {
                bigIcon = R.drawable.ic_z_big_libra
                smallIcon = R.drawable.ic_z_small_libra
                name = R.string.libra
                date = R.string.date_libra
                slogan = R.string.status_libra
            }
            ZodiacType.SCORPIO -> {
                bigIcon = R.drawable.ic_z_big_scorpio
                smallIcon = R.drawable.ic_z_small_scorpio
                name = R.string.scorpio
                date = R.string.date_scorpio
                slogan = R.string.status_scorpio
            }
            ZodiacType.SAGITTARIUS -> {
                bigIcon = R.drawable.ic_z_big_sagittarius
                smallIcon = R.drawable.ic_z_small_sagittarius
                name = R.string.sagittarius
                date = R.string.date_sagittarius
                slogan = R.string.status_sagittarius
            }
            ZodiacType.CAPRICORN -> {
                bigIcon = R.drawable.ic_z_big_capricorn
                smallIcon = R.drawable.ic_z_small_capricorn
                name = R.string.capricorn
                date = R.string.date_capricorn
                slogan = R.string.status_capricorn
            }
            ZodiacType.AQUARIUS -> {
                bigIcon = R.drawable.ic_z_big_aquarius
                smallIcon = R.drawable.ic_z_small_aquarius
                name = R.string.aquarius
                date = R.string.date_aquarius
                slogan = R.string.status_aquarius
            }
            ZodiacType.PISCES -> {
                bigIcon = R.drawable.ic_z_big_pisces
                smallIcon = R.drawable.ic_z_small_pisces
                name = R.string.pisces
                date = R.string.date_pisces
                slogan = R.string.status_pisces
            }
        }

        return Zodiac(zodiacType, bigIcon, smallIcon, name, date, slogan)
    }
}