package com.example.weatherui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.WitherInfo
import com.example.domain.usecase.GetWitheData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WitherViewModel @Inject constructor(
    private val useCase: GetWitheData
    ) : ViewModel() {
    private val _witherdata:MutableStateFlow<WitherInfo?> = MutableStateFlow(null)
    val witherdata:StateFlow<WitherInfo?> =_witherdata

    init {
        getWitherData()
    }
        fun getWitherData(){
            viewModelScope.launch {
                try{
                    _witherdata.value=  useCase()
                }
                catch (e:Exception){
                    Log.d("Wassam", "Error Messe:  ${e.message} ")
                }

            }

        }
}