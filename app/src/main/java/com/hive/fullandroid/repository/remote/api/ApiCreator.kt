package com.hive.fullandroid.repository.remote.api

import com.hive.fullandroid.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object apiCreator{

    private const val ONE_MINUTE: Long = 60

    private val client = OkHttpClient.Builder()
        .readTimeout(ONE_MINUTE, TimeUnit.SECONDS)
        .connectTimeout(ONE_MINUTE, TimeUnit.SECONDS)
//        .addInterceptor(createInterceptor())
        .build()

//    private fun createInterceptor(): Interceptor {
//        return Interceptor { chain ->
//            val request = chain?.request()?.newBuilder()?.addHeader("Client-ID", "q8f67qp225g6s7f6oep37u8hjf39ox")?.build();
//            chain?.proceed(request) }
//    }

    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
//        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(client)
        .build()


}