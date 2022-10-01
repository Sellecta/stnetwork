package shadowteam.ua.stnetwork.base

import retrofit2.Retrofit
import shadowteam.ua.stnetwork.convertors.STConvertors

object STRetrofit {

    private val scalaRetrofit = Retrofit
        .Builder().addConverterFactory(STConvertors.getScalaConvertors())
        .client(STHttp.getHttp())


    fun getScalaRetrofit(url: String): Retrofit {
        return scalaRetrofit
            .baseUrl(url)
            .build()
    }
}