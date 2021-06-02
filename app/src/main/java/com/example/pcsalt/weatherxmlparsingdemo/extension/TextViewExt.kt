package com.example.pcsalt.weatherxmlparsingdemo.extension

import android.widget.TextView

fun TextView.setTemp(resId: Int, celsius: Int, fahrenheit: Int) {
    this.text = this.context.getString(resId, celsius, fahrenheit)
}

fun TextView.setMsgTemp(resId: Int, msgResId: Int, celsius: Int, fahrenheit: Int) {
    this.text = this.context.getString(resId, this.context.getString(msgResId), celsius, fahrenheit)
}

