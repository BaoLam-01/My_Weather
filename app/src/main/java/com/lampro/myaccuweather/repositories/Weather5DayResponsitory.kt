package com.lampro.myaccuweather.repositories

import com.lampro.myaccuweather.network.api.ApiResponse
import com.lampro.myaccuweather.network.api.GenericApiResponse
import com.lampro.myaccuweather.network.api.clients.AccuClient
import com.lampro.myaccuweather.network.api.clients.OpenClient
import com.lampro.myaccuweather.objects.airqualityresponse.AirQualityResponse
import com.lampro.myaccuweather.objects.dailyweatherresponse.DailyWeatherResponse
import com.lampro.myaccuweather.objects.locationkeyresponse.LocationKeyResponse
import com.lampro.myaccuweather.objects.uvindexresponse.UVIndexResponse
import com.lampro.myaccuweather.utils.PrefManager

class Weather5DayResponsitory : GenericApiResponse() {
    val lang = PrefManager.getCurrentLang()
    val units = if (PrefManager.getCurrentUnits() == "℃") {
        "metric"
    } else {
        "imperial"
    }

    suspend fun getDailyWeather(cityName: String): ApiResponse<DailyWeatherResponse> {
        return apiCall { OpenClient.getOpenWeatherApi.getDailyWeather(cityName, lang, units) }
    }

    suspend fun getDailyWeather(lat: Double, lon: Double): ApiResponse<DailyWeatherResponse> {
        return apiCall {
            OpenClient.getOpenWeatherApi.getDailyWeather(
                lat.toString(),
                lon.toString(),
                lang,
                units
            )
        }
    }

    suspend fun getAirQuality(lat: Double, lon: Double): ApiResponse<AirQualityResponse> {
        return apiCall {
            OpenClient.getOpenWeatherApi.getAirQuality(lat.toString(), lon.toString())
        }
    }

    suspend fun getUvIndex(locationKey: String): ApiResponse<UVIndexResponse> {
        return apiCall {
            AccuClient.getAccuWeatherApi.getUvIndex(locationKey, lang)
        }
    }

    suspend fun getLocationKey(lat: Double, lon: Double): ApiResponse<LocationKeyResponse> {
        return apiCall {
            AccuClient.getAccuWeatherApi.getLocationKey("$lat,$lon", lang)
        }
    }
}