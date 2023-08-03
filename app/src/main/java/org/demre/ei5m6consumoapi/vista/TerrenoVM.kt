package org.demre.ei5m6consumoapi.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.demre.ei5m6consumoapi.data.Repositorio
import org.demre.ei5m6consumoapi.data.remote.Terreno
import org.demre.ei5m6consumoapi.data.remote.TerrenoRetrofit

class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    val terrenosLiveData = MutableLiveData<List<Terreno>>()

    init {
        val api = TerrenoRetrofit.getRetrofitTerreno()
        repositorio = Repositorio(api)
    }
    fun getAllTerrenos() = viewModelScope.launch{
        terrenosLiveData.value = repositorio.cargarTerreno()

    }

}