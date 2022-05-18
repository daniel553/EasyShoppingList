package com.tripletres.easyshoppinglist.util

import android.util.Log

/**
 * Use this loger to prevent logging in production unnecesary things
 */
object LogUtil {
    var level = LogLevel.DEBUG

    fun d(vararg logs: String) {
        if (level == LogLevel.DEBUG) {
            Log.d("LOGGER", logs.joinToString(separator = ", "))
        }
    }

    enum class LogLevel {
        NONE,
        DEBUG,
        PROD,
    }
}