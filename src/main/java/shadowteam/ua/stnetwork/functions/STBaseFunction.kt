package shadowteam.ua.stnetwork.functions

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import shadowteam.ua.stnetwork.api.STBaseApi
import shadowteam.ua.stnetwork.base.STRetrofit

object STBaseFunction {

    private const val BASE_URL = "https://www.cloudflare.com/"

    private suspend fun getTrace() = withContext(Dispatchers.IO) {
        var returnString = ""
        try {
            val api = STRetrofit
                .getScalaRetrofit(BASE_URL)
                .create(STBaseApi::class.java)
            val response = api.getTraceFromApi()
            if (response.isSuccessful) {
                response.body()?.let {
                    returnString = it
                }
            }
        } catch (e: Exception) {
            Log.i("MY_LOG", "CATCH ${e.message}")
        }
        returnString
    }
    suspend fun getMyPublicIP(): String{
        var ip = ""
        val tempStr = getTrace()
        if(tempStr.isNotBlank()){
            val temp = tempStr.split("\n")
            temp.forEach { str ->
                val value = str.split("=")
                if (value.size == 2 && value[0] == "ip") {
                    ip = value[1]
                }
            }
        }
        return ip
    }
}