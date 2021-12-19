package com.example.dosometin.network

import com.example.dosometin.repository.Repository
import com.example.dosometin.model.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRepository(
        api: DoSometinApi
    ) = Repository(api)

    @Singleton
    @Provides
    fun provideDoSometinApi(): DoSometinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DoSometinApi::class.java)
    }
}