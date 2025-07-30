package com.example.janitri_assignmment.manager

import android.content.Context
import androidx.work.*
import com.example.janitri_assignmment.worker.VitalReminderWorker
import java.util.concurrent.TimeUnit

class VitalReminderManager(private val context: Context) {
    
    companion object {
        private const val baby_reminder = "vital_reminder_work"
    }
    
    fun scheduleVitalReminders() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .setRequiresBatteryNotLow(false)
            .build()

        val reminderRequest = PeriodicWorkRequestBuilder<VitalReminderWorker>(
            5, TimeUnit.HOURS
        )
            .setConstraints(constraints)
            .setInitialDelay(5, TimeUnit.HOURS)
            .build()

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            baby_reminder,
            ExistingPeriodicWorkPolicy.KEEP,
            reminderRequest
        )
    }
    
    fun cancelVitalReminders() {
        WorkManager.getInstance(context).cancelUniqueWork(baby_reminder)
    }
}