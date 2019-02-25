package com.nzoth.presentation.features.horoscope.list

interface HoroscopeListContract {
    interface View {
        fun setMessage(text: String)

        fun setZodiac(iconRes:Int, nameRes: Int, dateRes: Int, sloganRes: Int)
    }

    interface Presenter {}
}