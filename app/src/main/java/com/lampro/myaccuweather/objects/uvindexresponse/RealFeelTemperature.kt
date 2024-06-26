package com.lampro.myaccuweather.objects.uvindexresponse


import com.google.gson.annotations.SerializedName

data class RealFeelTemperature(
    @SerializedName("Imperial")
    var imperial: ImperialXXXXXXXXXXXXXX,
    @SerializedName("Metric")
    var metric: MetricXXXXXXXXXXXXXX
)