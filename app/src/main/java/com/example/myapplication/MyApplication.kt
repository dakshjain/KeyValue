package com.example.myapplication

import android.app.Application
import com.example.keyvalue.SharedPrefs

class MyApplication: Application() {

    lateinit var sharedPrefs: SharedPrefs

    override fun onCreate() {
        super.onCreate()

        System.out.println("Starting KeyValue App")
        main()
    }
    fun main() {
        sharedPrefs = SharedPrefs.getSharedPrefsInstance(this)
        val key = "Key1"
        sharedPrefs.setStringParam(
            key, "value1"
        )

        val value = sharedPrefs.getParam<String>(key)
        System.out.println("key is $key and value is $value")
    }


}