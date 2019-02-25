package com.nzoth.presentation.features.horoscope.list

import com.nzoth.domain.UseCase
import com.nzoth.domain.horoscope.interactor.HoroscopeListUseCase
import com.nzoth.domain.zodiac.ZodiacType
import com.nzoth.domain.zodiac.ZodiacType.*
import com.nzoth.domain.zodiac.interactor.GetCurrentZodiacUseCase
import com.nzoth.presentation.R

class HoroscopeListPresenter(
        view: HoroscopeListContract.View,
        horoscopeListUseCase: HoroscopeListUseCase,
        getCurrentZodiacUseCase: GetCurrentZodiacUseCase
) : HoroscopeListContract.Presenter {
    init {
        getCurrentZodiacUseCase(UseCase.None()) {
            it.either({}, { zodiac ->
                view.setZodiac(
                        zodiac.bigIconRes,
                        zodiac.nameRes,
                        zodiac.dateRes,
                        zodiac.sloganRes
                )
            })
        }

//        horoscopeListUseCase(UseCase.None()) {
//            it.either({ throwable ->
//                throwable.toString()
//
//                view.setMessage("fail")
//            }, { result ->
//
//                view.setMessage("success" + result[0].title)
//            })
//        }
    }


}