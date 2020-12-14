package com.show.span

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE
import android.text.style.*
import android.view.View


inline val String.span get() = SpannableStringBuilder(this)

/**
 * ForegroundColorSpan  intRange [start,end)
 */
fun SpannableStringBuilder.foregroundColor(color:Int,intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE) = apply {
    setSpan(ForegroundColorSpan(color),intRange.first,intRange.last,flag)
}
/**
 * BackgroundColorSpan intRange [start,end)
 */
fun SpannableStringBuilder.backgroundColor(color:Int,intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE) = apply {
    setSpan(BackgroundColorSpan(color),intRange.first,intRange.last,flag)
}
/**
 * UnderlineSpan intRange [start,end)
 */
fun SpannableStringBuilder.underline(intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE) = apply {
    setSpan(UnderlineSpan(),intRange.first,intRange.last,flag)
}

/**
 * StrikethroughSpan intRange [start,end)
 */
fun SpannableStringBuilder.strikeThrough (intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE) = apply {
    setSpan(StrikethroughSpan(),intRange.first,intRange.last,flag)
}

/**
 * StyleSpan(Typeface.BOLD) intRange [start,end)
 */
fun SpannableStringBuilder.bold(intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE)= apply {
    setSpan(StyleSpan(Typeface.BOLD),intRange.first,intRange.last,flag)
}

/**
 * StyleSpan(Typeface.ITALIC) intRange [start,end)
 */
fun SpannableStringBuilder.italic(intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE)= apply {
    setSpan(StyleSpan(Typeface.ITALIC),intRange.first,intRange.last,flag)
}

/**
 * StyleSpan(Typeface.BOLD_ITALIC)  intRange [start,end)
 */
fun SpannableStringBuilder.boldItalic(intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE)= apply {
    setSpan(StyleSpan(Typeface.BOLD_ITALIC),intRange.first,intRange.last,flag)
}

/**
 * AbsoluteSizeSpan intRange [start,end)
 */
fun SpannableStringBuilder.size(size:Int,intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE)= apply {
    setSpan(AbsoluteSizeSpan(size,true),intRange.first,intRange.last,flag)
}

/**
 * RelativeSizeSpan intRange [start,end)
 */
fun SpannableStringBuilder.sizeRelative(scale:Float,intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE)= apply {
    setSpan(RelativeSizeSpan(scale),intRange.first,intRange.last,flag)
}

/**
 * ImageSpan intRange [start,end)
 */
fun SpannableStringBuilder.image(context:Context,bitmap: Bitmap,intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE)= apply {
    setSpan(ImageSpan(context,bitmap),intRange.first,intRange.last,flag)
}

/**
 * ImageSpan intRange [start,end)
 */
fun SpannableStringBuilder.image(drawable: Drawable,intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE)= apply {
    setSpan(ImageSpan(drawable),intRange.first,intRange.last,flag)
}

/**
 * ImageSpan intRange [start,end)
 */
inline fun SpannableStringBuilder.click(intRange: IntRange,flag:Int = SPAN_INCLUSIVE_INCLUSIVE,crossinline clickAction:(widget: View)->Unit)= apply {
    val clickableSpan= object : ClickableSpan() {
        override fun onClick(widget: View) {
            clickAction.invoke(widget)
        }
    }
    setSpan(clickableSpan,intRange.first,intRange.last,flag)
}