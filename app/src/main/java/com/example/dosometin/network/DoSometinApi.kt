package com.example.dosometin.network

import com.example.dosometin.model.Activity
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface DoSometinApi {

    @GET("/api/activity")
    suspend fun getRandomActivity(): Activity

    @GET("/api/activity?")
    suspend fun getActivity(
        @Query("type") type: String? = null,
        @Query("participants") participants: String? = null,
        @Query("accessibility") accessibility: String? = null,
    ): Activity

}