package com.show.string

import java.math.RoundingMode
import java.security.MessageDigest
import java.text.DecimalFormat


val String.md5
    get() = string2MD5(this)


fun string2MD5(inStr: String): String {
    var md5: MessageDigest? = null
    try {
        md5 = MessageDigest.getInstance("MD5")
    } catch (e: Exception) {
        println(e.toString())
        e.printStackTrace()
        return ""
    }

    val charArray = inStr.toCharArray()
    val byteArray = ByteArray(charArray.size)

    for (i in charArray.indices)
        byteArray[i] = charArray[i].toByte()
    val md5Bytes = md5!!.digest(byteArray)
    val hexValue = StringBuffer()
    for (i in md5Bytes.indices) {
        val `val` = md5Bytes[i].toInt() and 0xff
        if (`val` < 16)
            hexValue.append("0")
        hexValue.append(Integer.toHexString(`val`))
    }
    return hexValue.toString()

}

val Double.to2Decimal
    get() = double2Decimal(this)

val Float.to2Decimal
    get() = float2Decimal(this)


val Double.to1Decimal
    get() = double1Decimal(this)

val Float.to1Decimal
    get() = float1Decimal(this)


/**
 * 保留一位小数
 * @param num
 * @return
 */
private fun float1Decimal(num:Float): String {
    val df = DecimalFormat()
    df.maximumFractionDigits = 1
    df.groupingSize = 0
    df.roundingMode = RoundingMode.FLOOR
    val style = "###0.0"// 定义要显示的数字的格式
    df.applyPattern(style)
    return df.format(num)
}

/**
 * 保留一位小数
 * @param num
 * @return
 */
private fun double1Decimal(num:Double): String {
    val df = DecimalFormat()
    df.maximumFractionDigits = 1
    df.groupingSize = 0
    df.roundingMode = RoundingMode.FLOOR
    val style = "###0.0"// 定义要显示的数字的格式
    df.applyPattern(style)
    return df.format(num)
}

/**
 * 保留两位小数
 * @param num
 * @return
 */
private fun double2Decimal(num:Double): String {
    val df = DecimalFormat()
    df.maximumFractionDigits = 2
    df.groupingSize = 0
    df.roundingMode = RoundingMode.FLOOR
    val style = "###0.00"// 定义要显示的数字的格式
    df.applyPattern(style)
    return df.format(num)
}

/**
 * 保留两位小数
 * @param num
 * @return
 */
private fun float2Decimal(num: Float): String {
    val df = DecimalFormat()
    df.maximumFractionDigits = 2
    df.groupingSize = 0
    df.roundingMode = RoundingMode.FLOOR
    val style = "###0.00"// 定义要显示的数字的格式
    df.applyPattern(style)
    return df.format(num.toDouble())
}