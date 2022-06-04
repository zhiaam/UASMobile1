package com.example.countries.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.network.HeritageApi
import com.example.countries.network.Records
import kotlinx.coroutines.launch

enum class HeritageApiStatus {LOADING, ERROR, DONE}

class HeritageViewModel : ViewModel() {

    private val _status = MutableLiveData<HeritageApiStatus>()
    val status: LiveData<HeritageApiStatus> = _status

    private val _heritages = MutableLiveData<List<Records>>()
    val heritages: LiveData<List<Records>> = _heritages

    private val _heritage = MutableLiveData<Records>()
    val heritage: LiveData<Records> = _heritage

    fun getHeritageList() {
        viewModelScope.launch {
            _status.value = HeritageApiStatus.LOADING
            try {
                _heritages.value = HeritageApi.retrofitService.getHeritages().records
                _status.value = HeritageApiStatus.DONE
            } catch (e: Exception) {
                _status.value = HeritageApiStatus.ERROR
                _heritages.value = listOf()
                Log.i("Pesan Error Heritage:", "${e.message}")
            }
        }
    }

    fun onHeritageClicked(heritage: Records) {
        _heritage.value = heritage
    }
}
