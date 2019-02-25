package ua.com.myapps.horoscopus.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import ua.com.myapps.horoscopus.R

class TextFragment : BaseFragment() {
    override val layout: Int = R.layout.fragment_text

    companion object {
        private const val TEXT_TAG = "text_tag"
        fun newInstance(text: String) = TextFragment().apply {
            arguments = Bundle().apply { putString(TEXT_TAG, text) }
        }

        fun newInstance(textRes: Int) = TextFragment().apply {
            arguments = Bundle().apply { putInt(TEXT_TAG, textRes) }
        }
    }

    override fun onCreateView(view: View, savedInstanceState: Bundle?) {
        (view as TextView).text = arguments?.getString(TEXT_TAG) ?: arguments?.getInt(TEXT_TAG)?.let { activity?.getString(it) }
    }
}