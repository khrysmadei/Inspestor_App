package com.mobileapp.inspestor_vr5.utils

import android.app.Activity
import android.content.Context
import com.mobileapp.inspestor_vr5.R

object Animate {
    fun animateSlideLeft(context: Context) {
        (context as Activity).overridePendingTransition(
            R.anim.animate_slide_left_enter,
            R.anim.animate_slide_left_exit
        )
    }
}