package com.deshaies.interview_us_bank.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deshaies.interview_us_bank.data.Data
import com.deshaies.interview_us_bank.network.ApiClient
import kotlinx.coroutines.launch

class DataViewModel: ViewModel() {

    private val apiService = ApiClient.create()

    private val _data = MutableLiveData<List<Data>>()
    val data: LiveData<List<Data>> = _data

    val _error: MutableLiveData<String> = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchData(){

        viewModelScope.launch{
            try{
                val response = apiService.getData()
                if(response.isSuccessful){
                    _data.value = response.body()?.data
                    Log.d("API Response List", data.value.toString())
                }

                else{
                    _error.value = response.errorBody().toString()
                }

            }

            catch (e: Exception){
                e.printStackTrace()
                _error.value  = e.message
            }
        }
    }
}