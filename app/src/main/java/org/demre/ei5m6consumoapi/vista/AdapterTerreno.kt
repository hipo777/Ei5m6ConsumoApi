package org.demre.ei5m6consumoapi.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.demre.ei5m6consumoapi.data.remote.Terreno
import org.demre.ei5m6consumoapi.databinding.ItemTerrenoBinding

class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    private val listItemTerrenos = mutableListOf<Terreno>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemTerrenos.size

    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listItemTerrenos[position]
        holder.bind(terreno)
    }

    fun setData(terreno: List<Terreno>){
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v: ItemTerrenoBinding): RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: Terreno){
            v.img.load(terreno.img)
        }


    }
}