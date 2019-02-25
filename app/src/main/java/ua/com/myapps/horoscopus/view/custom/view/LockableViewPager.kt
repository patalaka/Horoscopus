package ua.com.myapps.horoscopus.view.custom.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.viewpager.widget.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class LockableViewPager : androidx.viewpager.widget.ViewPager {
    var swipeable: Boolean = true

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return if (swipeable) super.onTouchEvent(ev) else false
    }
}