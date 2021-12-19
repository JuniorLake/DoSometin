package com.example.dosometin.repository

import com.example.dosometin.model.Activity
import com.example.dosometin.network.DoSometinApi
import com.example.dosometin.resource.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class Repository @Inject constructor(
    private val doSometinApi: DoSometinApi
) {
    suspend fun getResponse(type:String?,participants:String?,accessibility:String?): Resource<Activity> {
        val response = try {
            if (type == null && participants == null && accessibility == null){
                doSometinApi.getRandomActivity()
            }
            else{
                doSometinApi.getActivity(type,participants,accessibility)
            }
        } catch (e: Exception){
            return Resource.Error("An Unknown error has occurred: ${e.localizedMessage}")
        }
        return Resource.Success(response)
    }
}