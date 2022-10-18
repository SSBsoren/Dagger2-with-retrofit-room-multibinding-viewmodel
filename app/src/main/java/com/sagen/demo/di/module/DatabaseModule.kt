package com.sagen.demo.di.module

import android.content.Context
import androidx.room.Room
import com.sagen.demo.data.local.RoomDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabaseInstance(context: Context): RoomDB {
        return Room.databaseBuilder(context, RoomDB::class.java, "test_db").build()

    }
}