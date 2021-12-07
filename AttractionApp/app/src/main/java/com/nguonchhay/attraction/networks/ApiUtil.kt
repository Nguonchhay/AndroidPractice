package com.nguonchhay.attraction.networks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object ApiUtil {
//
//    private const val BASE_URL = "https://my-json-server.typicode.com/"
//
//    fun  getInstance(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//}

class ApiUtil {
    companion object {
        //private const val BASE_URL = "https://my-json-server.typicode.com/"
        // https://beeceptor.com
        private const val BASE_URL = "https://nguonchhay.free.beeceptor.com/"

        fun  getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}