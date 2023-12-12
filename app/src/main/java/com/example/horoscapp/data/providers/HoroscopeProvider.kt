package com.example.horoscapp.data.providers

import com.example.horoscapp.domain.model.Aquarius
import com.example.horoscapp.domain.model.Aries
import com.example.horoscapp.domain.model.Cancer
import com.example.horoscapp.domain.model.Capricorn
import com.example.horoscapp.domain.model.Gemini
import com.example.horoscapp.domain.model.HoroscopeInfo
import com.example.horoscapp.domain.model.Leo
import com.example.horoscapp.domain.model.Libra
import com.example.horoscapp.domain.model.Pisces
import com.example.horoscapp.domain.model.Sagittarius
import com.example.horoscapp.domain.model.Scorpio
import com.example.horoscapp.domain.model.Taurus
import com.example.horoscapp.domain.model.Virgo
import javax.inject.Inject


class HoroscopeProvider @Inject constructor() {
    fun getHoroscope(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}