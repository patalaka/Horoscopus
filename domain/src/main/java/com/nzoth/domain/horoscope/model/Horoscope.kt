package com.nzoth.domain.horoscope.model

import com.nzoth.domain.horoscope.HoroscopeType

data class Horoscope(
        val type: HoroscopeType,
        val title: String,
        val content: String
)