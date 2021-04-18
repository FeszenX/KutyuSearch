package com.example.kutyusearch.repository.database

import androidx.room.*
import com.example.kutyusearch.model.DogBread

@Dao
interface DogBreadDAO {
    @Query("SELECT * FROM breads")
    fun getAllBreads(): List<DogBread>

    @Query("SELECT * FROM breads WHERE id == :id")
    fun getBread(id: String): List<DogBread>

    @Insert
    fun insertBread(bread: DogBread): Long

    @Delete
    fun deleteBread(bread: DogBread)

    @Update
    fun updateBread(bread: DogBread)
}