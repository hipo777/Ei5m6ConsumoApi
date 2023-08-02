package org.demre.ei5m6consumoapi.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TerrenoRetrofit {
    companion object {
        private const val URL_BASE = "https://android-kotlin-fun-mars-server.appspot.com/"
        fun getRetrofitTerreno(): TerrenoApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)

                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(TerrenoApi::class.java)
        }
    }
}