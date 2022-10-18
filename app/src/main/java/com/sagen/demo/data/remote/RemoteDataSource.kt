package com.sagen.demo.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sagen.demo.data.model.CollectionResp
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    private val _collections = MutableLiveData<CollectionResp>()
    private val collections: LiveData<CollectionResp> get() = _collections

    suspend fun getCollectionDataByUserId(userId: String): LiveData<CollectionResp> {
        val response = apiService.getCollectionDataByUserId(userId)
        if (response.isSuccessful && response.code() == 200) {
            _collections.postValue(response.body())
        }
        return collections
    }
}