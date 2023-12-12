package com.example.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscapp.data.providers.HoroscopeProvider
import com.example.horoscapp.domain.model.Aries
import com.example.horoscapp.domain.model.Gemini
import com.example.horoscapp.domain.model.HoroscopeInfo
import com.example.horoscapp.domain.model.Taurus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider):ViewModel()  {

    /**
     * Aqui en esta linea se crea los STATE FLOWS
     */
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope

    init {

        _horoscope.value = horoscopeProvider.getHoroscope()
    }
}