package com.show.view

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.util.Log
import android.view.View
import android.view.animation.Interpolator
import android.view.animation.LinearInterpolator


fun View.rotateX(x: Float, duration: Long, interpolator: Interpolator = LinearInterpolator()) =
    rotateXY(x, null, duration, interpolator)

fun View.rotateY(y: Float, duration: Long, interpolator: Interpolator = LinearInterpolator()) =
    rotateXY(null, y, duration, interpolator)


fun View.rotateXY(
    x: Float? = null,
    y: Float? = null,
    duration: Long,
    interpolator: Interpolator
): AnimatorSet {

    val fromX = rotationX
    val fromY = rotationY

    val animatorX: ValueAnimator? = if (x != null) {
        ObjectAnimator.ofFloat(this, "rotationX", fromX, x.toFloat())
    } else {
        null
    }

    val animatorY: ValueAnimator? = if (y != null) {
        ObjectAnimator.ofFloat(this, "rotationY", fromY, y.toFloat())
    } else {
        null
    }

    return AnimatorSet()
        .setDuration(duration)
        .apply {
            if (animatorX != null && animatorY != null) {
                playTogether(animatorX, animatorY)
            } else if (animatorX != null) {
                play(animatorX)
            } else if (animatorY != null) {
                play(animatorY)
            }
            setInterpolator(interpolator)
        }
}


fun View.alphaTo(
    toAlpha: Float,
    duration: Long,
    interpolator: Interpolator = LinearInterpolator()
): Animator {
    val fromAlpha = alpha
    return ObjectAnimator.ofFloat(this, "alpha", fromAlpha, toAlpha.toFloat()).apply {
        setDuration(duration)
        setInterpolator(interpolator)
    }
}

fun View.scaleX(x: Float, duration: Long, interpolator: Interpolator = LinearInterpolator()) =
    scaleXY(x, null, duration, interpolator)

fun View.scaleY(y: Float, duration: Long, interpolator: Interpolator = LinearInterpolator()) =
    scaleXY(null, y, duration, interpolator)


fun View.scaleXY(
    x: Float? = null,
    y: Float? = null,
    duration: Long,
    interpolator: Interpolator
): AnimatorSet {

    val fromX = translationX
    val fromY = translationY


    val animatorX: ValueAnimator? = if (x != null) {
        ObjectAnimator.ofFloat(this, "scaleX", fromX, x.toFloat())
    } else {
        null
    }

    val animatorY: ValueAnimator? = if (y != null) {
        ObjectAnimator.ofFloat(this, "scaleY", fromY, y.toFloat())
    } else {
        null
    }

    return AnimatorSet()
        .setDuration(duration)
        .apply {
            if (animatorX != null && animatorY != null) {
                playTogether(animatorX, animatorY)
            } else if (animatorX != null) {
                play(animatorX)
            } else if (animatorY != null) {
                play(animatorY)
            }
            setInterpolator(interpolator)
        }
}


fun View.translateToX(x: Float, duration: Long, interpolator: Interpolator = LinearInterpolator()) =
    translateToXY(x, null, duration, interpolator)

fun View.translateToY(y: Float, duration: Long, interpolator: Interpolator = LinearInterpolator()) =
    translateToXY(null, y, duration, interpolator)


fun View.translateToXY(
    x: Float? = null,
    y: Float? = null,
    duration: Long,
    interpolator: Interpolator
): AnimatorSet {

    val fromX = translationX
    val fromY = translationY


    val animatorX: ValueAnimator? = if (x != null) {
        ObjectAnimator.ofFloat(this, "translationX", fromX, x.toFloat())
    } else {
        null
    }

    val animatorY: ValueAnimator? = if (y != null) {
        ObjectAnimator.ofFloat(this, "translationY", fromY, y.toFloat())
    } else {
        null
    }

    return AnimatorSet()
        .setDuration(duration)
        .apply {
            if (animatorX != null && animatorY != null) {
                playTogether(animatorX, animatorY)
            } else if (animatorX != null) {
                play(animatorX)
            } else if (animatorY != null) {
                play(animatorY)
            }
            setInterpolator(interpolator)
        }
}



