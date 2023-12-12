package com.example.horoscapp.domain.model

import com.example.horoscapp.data.network.response.PredictionResponse

interface Repository {

    suspend fun getPrediction(sign:String): PredictionModel?
}