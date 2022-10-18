package com.sagen.demo.data.local

import com.sagen.demo.data.model.CollectionInput
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val roomDB: RoomDB) {

    suspend fun saveCollectionsInput(collections: List<CollectionInput>){
        roomDB.getMainDAO().insertCollectionInput(collections)
    }
}