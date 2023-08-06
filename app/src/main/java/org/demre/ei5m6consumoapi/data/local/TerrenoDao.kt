package org.demre.ei5m6consumoapi.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TerrenoDao {
    @Insert
    suspend fun insertarTerreno (terrenoEntity: TerrenoEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTerrenos (terrenosEntity: List<TerrenoEntity>)

    @Query("SELECT * FROM tabla_terreno order by id ASC")
    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>

    @Query("Select * From tabla_terreno where id =:id")
    fun getTerreno(id: String): LiveData<TerrenoEntity>
}