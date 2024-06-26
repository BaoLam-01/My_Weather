package com.lampro.myaccuweather.viewmodels.location

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lampro.myaccuweather.MyApplication
import com.lampro.myaccuweather.repositories.LocationResponsitory

class LocationViewModelFactory(
    val application: Application,
    val locationResponsitory: LocationResponsitory
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LocationViewModel(application,locationResponsitory) as T
    }
}