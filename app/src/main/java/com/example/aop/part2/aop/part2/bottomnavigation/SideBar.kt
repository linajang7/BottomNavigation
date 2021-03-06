package com.example.aop.part2.aop.part2.bottomnavigation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.TextView

class SideBar : View {
    private var mOnTouchingLetterChangedListener: OnTouchingLetterChangedListener? = null
    private var mChoose = -1
    private val mPaint = Paint()

    private var mTextDialog: TextView? = null

    fun setTextView(textDialog: TextView) {
        this.mTextDialog = textDialog
    }

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val height = height
        val width = width
        val singleHeight = height / BAR_VALUE.size

        for (i in BAR_VALUE.indices) {
            mPaint.color = color(R.color.colorPrimaryLight)
            mPaint.typeface = Typeface.DEFAULT_BOLD
            mPaint.isAntiAlias = true
            mPaint.textSize = dp2px(context, 12.0).toFloat()

            if (i == mChoose) {
                mPaint.color = color(R.color.colorPrimary)
                mPaint.isFakeBoldText = true
            }

            val xPos = width / 2 - mPaint.measureText(BAR_VALUE[i]) / 2
            val yPos = (singleHeight * i + singleHeight).toFloat()
            canvas.drawText(BAR_VALUE[i], xPos, yPos, mPaint)
            mPaint.reset()
        }

    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
        val y = event.y
        val oldChoose = mChoose
        val listener = mOnTouchingLetterChangedListener
        val c = (y / height * BAR_VALUE.size).toInt()

        when (action) {
            MotionEvent.ACTION_UP -> {
                setBackgroundColor(android.R.color.transparent)
                mChoose = -1
                invalidate()
                if (mTextDialog != null) {
                    mTextDialog!!.visibility = View.INVISIBLE
                }
            }
            else -> {
                setBackgroundResource(R.drawable.sidebar_background)
                // judge if chosen letter changed
                if (oldChoose != c) {
                    if (c >= 0 && c < BAR_VALUE.size) {
                        listener?.onTouchingLetterChanged(BAR_VALUE[c])
                        if (mTextDialog != null) {
                            mTextDialog!!.text = BAR_VALUE[c]
                            mTextDialog!!.visibility = VISIBLE
                        }

                        mChoose = c
                        invalidate()
                    }
                }
            }
        }
        return true
    }

    fun setOnTouchingLetterChangedListener(onTouchingLetterChangedListener: OnTouchingLetterChangedListener) {
        this.mOnTouchingLetterChangedListener = onTouchingLetterChangedListener
    }

    companion object {
        var BAR_VALUE = arrayOf(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#")
    }

}