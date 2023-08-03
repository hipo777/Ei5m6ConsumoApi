package org.demre.ei5m6consumoapi.data

import org.demre.ei5m6consumoapi.data.remote.Terreno
import org.demre.ei5m6consumoapi.data.remote.TerrenoApi

class Repositorio(private val terrenoApi: TerrenoApi) {
    suspend fun cargarTerreno(): List<Terreno>{
        val respuesta = terrenoApi.getData()
        if (respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let {
                return it
            }
        }
        return emptyList()
    }
}