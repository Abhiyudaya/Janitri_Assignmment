package com.example.janitri_assignmment.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalLogDao {
    @Query("SELECT * FROM vital_logs ORDER BY timestamp DESC")
    fun getAllVitalLogs(): Flow<List<VitalLog>>

    @Insert
    suspend fun insertVitalLog(vitalLog: VitalLog)
}