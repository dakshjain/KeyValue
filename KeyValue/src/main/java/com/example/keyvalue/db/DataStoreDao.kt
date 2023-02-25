package com.example.keyvalue.db

import androidx.room.Dao
import androidx.room.Query
import com.example.keyvalue.DataType


@Dao
interface DataStoreDao {

    @Query("Insert into datastore")
    fun insertparam(key: String, value: String, dataType: DataType)

    @Query("select * from datastore where key = 'key'")
    fun getParam(key: String): DataStore
}