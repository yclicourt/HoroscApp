package com.example.horoscapp.data.network.response


import org.junit.Assert.*
import org.junit.Test

class PredictionResponseTest {

    @Test
    fun `toDomain Should Returna Correct Prediction Model`(){
        //Given
        val horoscopeResponse = PredictionResponse("date","prediction","taurus")

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        //predictionModel.sign shouldBe horoscopeResponse.sign
        //predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }

}