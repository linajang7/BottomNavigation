package com.example.aop.part2.aop.part2.bottomnavigation

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat

val View.ctx: Context
    get() = context

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)

fun View.color(res: Int): Int = ContextCompat.getColor(ctx, res)

fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}

fun dp2px(context: Context, dpValue: Double): Int {
    val scale = context.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}