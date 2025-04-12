package com.test.securefetch

import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getTodos(): List<Tods>
}
