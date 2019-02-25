package com.nzoth.presentation.features.horoscope.list

interface HoroscopeListContract {
    interface View{
        fun setMessage(text:String)
    }
    interface Presenter{}
}