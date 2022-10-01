package shadowteam.ua.stnetwork.base

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object STHttp {

    private val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client = OkHttpClient
        .Builder().addInterceptor(loggingInterceptor)
        .build()

    fun getHttp() = client
}