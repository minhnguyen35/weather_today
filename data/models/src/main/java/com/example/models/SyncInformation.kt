package com.example.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "SyncData",
    )
data class SyncInformation(
    @PrimaryKey
    @ColumnInfo("attribute")
    val attribute: String,
    @ColumnInfo("value")
    val value: String,
    @ColumnInfo("value_type")
    val valueType: String,
): WeatherEntity
