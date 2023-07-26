package com.deshaies.interview_us_bank.network

//import com.deshaies.interview_us_bank.data.Data
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("rates")
    suspend fun getData(): Response<com.deshaies.interview_us_bank.data.Response>
}