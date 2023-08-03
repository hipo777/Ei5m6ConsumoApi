package org.demre.ei5m6consumoapi.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface TerrenoApi {
    @GET("realestate")//endpoint
    suspend fun getData(): Response<List<Terreno>>


}