package com.example.horoscapp.data

import android.util.Log
import com.example.horoscapp.data.network.HoroscopeApiService
import com.example.horoscapp.data.network.response.PredictionResponse
import com.example.horoscapp.domain.model.PredictionModel
import com.example.horoscapp.domain.model.Repository

import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService:HoroscopeApiService):Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        //Peticion Retrofit
        runCatching { apiService.getHoroscope(sign)  }
            .onSuccess { return it.toDomain()}
            .onFailure { Log.i("yoan","Ha ocurrido un error ${it.message}") }

        return null
    }
}