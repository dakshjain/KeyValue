package com.example.keyvalue

import com.google.gson.Gson
import org.json.JSONObject



    fun Int.toJsonString()  = JSONObject(this.toString()).toString()

    fun Double.toJsonString()  = JSONObject(this.toString()).toString()

    fun Boolean.toJsonString()  = JSONObject(this.toString()).toString()

    fun Any.toJsonString(): String {
        return Gson().toJson(this).toString()
    }
