package com.example.horoscapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle.State.STARTED
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.horoscapp.databinding.FragmentHoroscBinding
import com.example.horoscapp.domain.model.Aquarius
import com.example.horoscapp.domain.model.Aries
import com.example.horoscapp.domain.model.Cancer
import com.example.horoscapp.domain.model.Capricorn
import com.example.horoscapp.domain.model.Gemini
import com.example.horoscapp.domain.model.HoroscopeModel
import com.example.horoscapp.domain.model.Leo
import com.example.horoscapp.domain.model.Libra
import com.example.horoscapp.domain.model.Pisces
import com.example.horoscapp.domain.model.Sagittarius
import com.example.horoscapp.domain.model.Scorpio
import com.example.horoscapp.domain.model.Taurus
import com.example.horoscapp.domain.model.Virgo
import com.example.horoscapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    /**
     * Aqui en esta linea se conecta el fragment con el viewModel
     * usando un delegado con by viewModels
     */
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeAdapter: HoroscopeAdapter

    private var _binding: FragmentHoroscBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
           val type: HoroscopeModel = when(it){
                Aquarius -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricorn -> HoroscopeModel.Capricorn
                Gemini -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Pisces -> HoroscopeModel.Pisces
                Sagittarius -> HoroscopeModel.Sagittarius
                Scorpio -> HoroscopeModel.Scorpio
                Taurus -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo

           }
            findNavController().navigate(
                HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
            )
        })
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() {
        /**
         * En esta linea usamos esta corrutina lifecycleScope para engancharnos al ciclo de vida del
         * fragment, ademas aqui hacemos la conexion del fragment con el stateflow
         */
        lifecycleScope.launch {
            repeatOnLifecycle(STARTED) {
                horoscopeViewModel.horoscope.collect() {
                    //Cambios en HOROSCOPE
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}