package com.example.memefy.Model.Getmemes

import android.content.Context

class MySharedPref(context:Context) {

    companion object {
        private const val FILE_KEY = "user_info"
        private const val title = "url"
        private const val url1 = "url"
        private const val num = "0"

    }

    private val sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE)

    fun saveUsername(name: String){
        sharedPref.edit()
            .putString(title, name)
            .apply()
    }

    fun getUsername(): String? {
        return sharedPref.getString(title, null)
    }

    fun saveUrl(url: String){
        sharedPref.edit()
            .putString(url1, url)
            .apply()
    }

    fun geturl(): String? {
        return sharedPref.getString(url1, null)
    }

    fun save(num1: String){
        sharedPref.edit()
            .putString(num, num1)
            .apply()
    }

    fun getnum(): String?{
        return sharedPref.getString(num, null )
    }


}