package com.sagen.demo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sagen.demo.data.model.CollectionInput
import com.sagen.demo.data.model.CollectionResp
import com.sagen.demo.data.repository.Repository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    suspend fun getCollectionDataByUserId(userId: String): LiveData<CollectionResp> {
        return repository.remote.getCollectionDataByUserId(userId)
    }

    suspend fun saveIntoLocalDatasource(collections: List<CollectionInput>) {
        repository.local.saveCollectionsInput(collections)

    }


}