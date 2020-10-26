package com.devlopersquad.testcustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView


class MyTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {
    private val paint: Paint = Paint()
    private var isLeftBorder = false
    private var isRightBorder = false
    private var isTopBorder = false
    private var isBottomBorder = false

    private var allBorders = false
    private val rect = Rect()

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.MyTextView,
            0, 0
        ).apply {
            try {
                isLeftBorder = getBoolean(R.styleable.MyTextView_isLeftBorder, false)
                isRightBorder = getBoolean(R.styleable.MyTextView_isRightBorder, false)
            } finally {
                recycle()
            }
        }
        paint.apply {
            color = Color.RED
            strokeWidth = 4f
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        rect.left = 0
        rect.top = 0
        rect.right = width
        rect.bottom = height
        canvas?.drawRect(rect, paint)

        /*if (isRightBorder) {
            canvas?.drawLine(width + 0f, 0f, width + 0f, height + 0f, paint)
        } else if(isLeftBorder) {

        }*/
    }
}