package com.example.keyvalue.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.keyvalue.DataType


@Entity
data class DataStore(
    @ColumnInfo
    @PrimaryKey
    val key: String,
    @ColumnInfo
    val value: String,
    @ColumnInfo
    val dataType: DataType


)