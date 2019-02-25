package com.nzoth.domain.zodiac.model

import com.nzoth.domain.zodiac.ZodiacType

data class Zodiac(
        val type: ZodiacType,
        val bigIconRes: Int,
        val smallIconRes: Int,
        val nameRes: Int,
        val dateRes: Int,
        val sloganRes: Int
)