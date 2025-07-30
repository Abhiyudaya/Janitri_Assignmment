package com.example.janitri_assignmment.repository

import com.example.janitri_assignmment.data.VitalLog
import com.example.janitri_assignmment.data.VitalLogDao
import kotlinx.coroutines.flow.Flow

class VitalLogRepository(
    private val vitalLogDao: VitalLogDao
) {
    fun getAllVitalLogs(): Flow<List<VitalLog>> {
        return vitalLogDao.getAllVitalLogs()
    }

    suspend fun insertVitalLog(vitalLog: VitalLog) {
        vitalLogDao.insertVitalLog(vitalLog)
    }
}