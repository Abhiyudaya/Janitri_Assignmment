package com.example.janitri_assignmment.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "vital_logs")
data class VitalLog(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val systolicPressure: Int,
    val diastolicPressure: Int,
    val heartRate: Int,
    val weight: Float,
    val babyKicksCount: Int,
    val timestamp: Date = Date()
)