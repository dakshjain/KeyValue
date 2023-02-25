package com.example.keyvalue

import android.app.Application
import com.example.keyvalue.db.DatabaseManager


open class SharedPrefs {
    companion object {
        lateinit var sharedPrefs: SharedPrefs

        fun getSharedPrefsInstance(application: Application): SharedPrefs {
            return if (!this::sharedPrefs.isInitialized) {
                sharedPrefs = SharedPrefs(application)
                return sharedPrefs
            }else {
                sharedPrefs
            }
        }
    }

    lateinit var application : Application
    private constructor(application: Application) {
        this.application  = application
    }


    fun getDb(application: Application): DatabaseManager {
        return DatabaseManager.buildDatabase(application.applicationContext)
    }

    fun getParam(key: String): String {
        val dataStore =  getDb(application).dataStoreDto().getParam(key)
        return dataStore.value
    }

    private fun setParam(key: String, value: String, dataType: DataType) {
        getDb(application).dataStoreDto().insertparam(key, value, dataType)
    }

    fun setIntParam(key: String, value: Int) {
        setParam(key, value.toJsonString(), DataType.Int)
    }


    fun setDoubleParam(key: String, value: Double) {
        setParam(key, value.toJsonString(), DataType.Double)
    }

    fun setBooleanParam(key: String, value: Boolean) {
        setParam(key, value.toJsonString(), DataType.Boolean)
    }

    fun setStringParam(key: String, value: String) {
        setParam(key, value.toJsonString(), DataType.String)
    }

    fun setGenericParam(key: String, value: Any) {
        setParam(key, value.toJsonString(), DataType.Generic)
    }

}

enum class DataType {
    String, Int, Boolean, Double, Generic
}