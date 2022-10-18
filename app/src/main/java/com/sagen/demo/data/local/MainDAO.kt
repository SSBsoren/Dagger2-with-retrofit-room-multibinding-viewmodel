package com.sagen.demo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sagen.demo.data.model.CollectionInput

@Dao
interface MainDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollectionInput(collections: List<CollectionInput>)

    @Query("SELECT * FROM collection_input")
    suspend fun getAllCollectionInput(): List<CollectionInput>
}