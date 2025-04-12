package com.test.securefetch

import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(getPinnedOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun getPinnedOkHttpClient(): OkHttpClient {
        val certificatePinner = CertificatePinner.Builder()
            .add("jsonplaceholder.typicode.com", "sha256/eU8uhA6QAxYsY/XmB8tU2nji6+Ccm1bkv+byr04/qwg=")
            .build()

        return OkHttpClient.Builder()
            .certificatePinner(certificatePinner)
            .build()
    }

}
