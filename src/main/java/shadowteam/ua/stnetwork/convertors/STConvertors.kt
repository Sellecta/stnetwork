package shadowteam.ua.stnetwork.convertors

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object STConvertors {

    fun getScalaConvertors(): ScalarsConverterFactory {
        return ScalarsConverterFactory.create()
    }
    fun getGsonConvertor(): GsonConverterFactory{
        return GsonConverterFactory.create()
    }
}