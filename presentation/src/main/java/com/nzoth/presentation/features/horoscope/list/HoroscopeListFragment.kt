package com.nzoth.presentation.features.horoscope.list

import android.os.Bundle
import android.view.View
import com.nzoth.presentation.R
import com.nzoth.presentation.core.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_horoscope_list.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HoroscopeListFragment : BaseFragment(), HoroscopeListContract.View {
    private val presenter: HoroscopeListContract.Presenter by inject { parametersOf(this) }

    override val resourceLayout: Int = R.layout.fragment_horoscope_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.toString()
    }

    override fun setMessage(text: String) {
    }

//    override fun setZodiac(name: String, date: String, slogan: String) {
//        titleView.text = name
//        dateView.text = date
//        sloganView.text = slogan
//    }

    override fun setZodiac(iconRes: Int, nameRes: Int, dateRes: Int, sloganRes: Int) {
        imageView.setImageResource(iconRes)
        titleView.setText(nameRes)
        dateView.setText(dateRes)
        sloganView.setText(sloganRes)
    }
}