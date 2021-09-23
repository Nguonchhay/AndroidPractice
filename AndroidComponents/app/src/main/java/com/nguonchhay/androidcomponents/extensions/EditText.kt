package com.nguonchhay.androidcomponents.extensions

import android.text.InputType
import android.widget.EditText

fun EditText.disableClick() {
    this.isFocusable = true
    this.isFocusableInTouchMode = true
    this.inputType = InputType.TYPE_NULL
}

fun EditText.enableClick() {
    this.isFocusable = true
    this.isFocusableInTouchMode = true
    this.inputType = InputType.TYPE_CLASS_TEXT
}