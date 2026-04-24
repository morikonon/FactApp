package com.example.data

import com.example.domain.FactRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindRepository(impl: FactRepositoryImpl): FactRepository

    companion object {
        @Provides
        @Singleton
        fun provideApi(): FactApi {
            return Retrofit.Builder()
                .baseUrl("https://catfact.ninja/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FactApi::class.java)
        }
    }
}