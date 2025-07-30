package com.example.janitri_assignmment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.janitri_assignmment.data.VitalLog
import com.example.janitri_assignmment.data.VitalLogDatabase
import com.example.janitri_assignmment.repository.VitalLogRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VitalLogViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: VitalLogRepository
    
    private val _vitalLogs = MutableStateFlow<List<VitalLog>>(emptyList())
    val vitalLogs: StateFlow<List<VitalLog>> = _vitalLogs.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    init {
        val database = VitalLogDatabase.getDatabase(application)
        repository = VitalLogRepository(database.vitalLogDao())
        
        viewModelScope.launch {
            repository.getAllVitalLogs().collect { logs ->
                _vitalLogs.value = logs
            }
        }
    }
    
    fun addVitalLog(
        systolicPressure: Int,
        diastolicPressure: Int,
        heartRate: Int,
        weight: Float,
        babyKicksCount: Int
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val vitalLog = VitalLog(
                    systolicPressure = systolicPressure,
                    diastolicPressure = diastolicPressure,
                    heartRate = heartRate,
                    weight = weight,
                    babyKicksCount = babyKicksCount
                )
                repository.insertVitalLog(vitalLog)
            }
            finally {
                _isLoading.value = false
            }
        }
    }
}