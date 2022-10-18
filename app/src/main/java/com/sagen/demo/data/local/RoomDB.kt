package com.sagen.demo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sagen.demo.data.model.CollectionInput

@Database(entities = [CollectionInput::class], version = 1)
abstract class RoomDB :RoomDatabase(){
    abstract fun getMainDAO():MainDAO
}