package org.demre.ei5m6consumoapi.data

import androidx.lifecycle.LiveData
import org.demre.ei5m6consumoapi.data.local.TerrenoDao
import org.demre.ei5m6consumoapi.data.local.TerrenoEntity
import org.demre.ei5m6consumoapi.data.remote.Terreno
import org.demre.ei5m6consumoapi.data.remote.TerrenoApi

class Repositorio(private val terrenoApi: TerrenoApi, private val terrenoDao: TerrenoDao) {

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos()

    suspend fun cargarTerreno() {

        val respuesta = terrenoApi.getData()

        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let { terrenos ->
                val terrenosEntity = terrenos.map { it.transformar() }
                terrenoDao.insertarTerrenos(terrenosEntity)
            }
        }

    }
    fun getTerreno(id: String): LiveData<TerrenoEntity> = terrenoDao.getTerreno(id)

    fun Terreno.transformar(): TerrenoEntity =
        TerrenoEntity(this.id, this.precio, this.tipo, this.imagen)
}

