package shadowteam.ua.stnetwork.api

import retrofit2.Response
import retrofit2.http.GET

internal interface STBaseApi {

    @GET("cdn-cgi/trace")
    suspend fun getTraceFromApi() :Response<String>
}