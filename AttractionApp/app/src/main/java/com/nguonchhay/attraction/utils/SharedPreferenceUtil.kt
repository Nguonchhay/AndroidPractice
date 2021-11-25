package com.nguonchhay.attraction.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceUtil() {
    private val PRE_NAME = "AttractionApp"
    private val PRIVATE_MODE = 0

    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    constructor(con: Context) : this() {
        pref = con.getSharedPreferences(PRE_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    fun storeItem(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getItem(key: String) = pref.getString(key, "")
}