package com.tripletres.easyshoppinglist.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

class MessageUtil constructor(val context: Context) {

    fun toast(msg: String, length: Int) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun toast(@StringRes msg: Int, length: Int) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}