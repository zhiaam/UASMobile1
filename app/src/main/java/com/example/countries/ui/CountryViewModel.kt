package com.example.countries.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.network.Country
import com.example.countries.network.CountryApi
import kotlinx.coroutines.launch

enum class CountryApiStatus {LOADING, ERROR, DONE}

class CountryViewModel : ViewModel() {

    private val _status = MutableLiveData<CountryApiStatus>()
    val status: LiveData<CountryApiStatus> = _status

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    private val _country = MutableLiveData<Country>()
    val country: LiveData<Country> = _country

    fun getCountryList() {
        viewModelScope.launch {
            _status.value = CountryApiStatus.LOADING
            try {
                _countries.value = CountryApi.retrofitService.getCountries()
                _status.value = CountryApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CountryApiStatus.ERROR
                _countries.value = listOf()
                Log.i("Pesan Error :", "${e.message}")
            }
        }
    }

    fun onCountryClicked(country: Country) {
        _country.value = country
    }
}
