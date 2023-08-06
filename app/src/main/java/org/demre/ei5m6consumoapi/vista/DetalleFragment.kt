package org.demre.ei5m6consumoapi.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import org.demre.ei5m6consumoapi.databinding.FragmentDetalleBinding

private const val ARG_PARAM1 = "id"

class DetalleFragment : Fragment() {

    private lateinit var binding: FragmentDetalleBinding
    private var param1: String? = null
    private val terrenoVM: TerrenoVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)
        terrenoVM.terrenoLiveData(param1.toString()).observe(viewLifecycleOwner) {
            binding.tvID.text = it.id
            binding.tvPrice.text = it.precio.toString()
            binding.tvType.text = it.tipo
            binding.imag.load(it.imagen)
        }
        return binding.root
    }


}