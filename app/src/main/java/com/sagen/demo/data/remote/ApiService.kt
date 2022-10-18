package com.sagen.demo.data.remote

import com.sagen.demo.data.model.CollectionResp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("user/data/{userId}")
    suspend fun getCollectionDataByUserId(@Path("userId") userId: String): Response<CollectionResp>
}