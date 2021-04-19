package com.example.kutyusearch.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breads")
data class DogBread(
    @PrimaryKey(autoGenerate = true) var breadId : Long?,
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String
)
