package com.example.countries.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://examples.opendatasoft.com/api/records/1.0/search/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HeritageApiService {
    @GET("?dataset=world-heritage-unesco-list&q=&rows=50")
    suspend fun getHeritages(): Heritage
}

object HeritageApi {
    val retrofitService: HeritageApiService by lazy {
        retrofit.create(HeritageApiService::class.java)
    }
}

