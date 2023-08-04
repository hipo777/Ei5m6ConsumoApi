package org.demre.ei5m6consumoapi.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import org.demre.ei5m6consumoapi.databinding.FragmentListadoBinding

class ListadoFragment : Fragment() {

    lateinit var binding: FragmentListadoBinding
    private val terrenoVM: TerrenoVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListadoBinding.inflate(layoutInflater, container, false)



        binding.btnCargar.setOnClickListener{
            terrenoVM.obtenerTerreno()
            initAdapter()
        }

        return binding.root

    }

    private fun initAdapter() {
        //terrenoVM.getAllTerrenos()
        val adapter = AdapterTerreno()

        binding.rvRecycler.adapter = adapter
        terrenoVM.terrenosLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }

}