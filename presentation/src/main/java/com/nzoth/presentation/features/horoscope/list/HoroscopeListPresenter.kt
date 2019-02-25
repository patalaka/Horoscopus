package com.nzoth.presentation.features.horoscope.list

import com.nzoth.domain.UseCase
import com.nzoth.domain.horoscope.interactor.HoroscopeListUseCase

class HoroscopeListPresenter(
        view: HoroscopeListContract.View,
        horoscopeListUseCase: HoroscopeListUseCase
) : HoroscopeListContract.Presenter {
    init {
        horoscopeListUseCase(UseCase.None()) {
            it.either({ throwable ->
                throwable.toString()

                view.setMessage("fail")
            }, { result ->

                view.setMessage("success" + result[0].title)
            })
        }
    }
}