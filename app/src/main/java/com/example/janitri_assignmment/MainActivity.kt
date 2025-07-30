package com.example.janitri_assignmment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.janitri_assignmment.manager.VitalReminderManager
import com.example.janitri_assignmment.ui.VitalLogScreen
import com.example.janitri_assignmment.ui.theme.Janitri_AssignmmentTheme
import com.example.janitri_assignmment.viewmodel.VitalLogViewModel

class MainActivity : ComponentActivity() {
    
    private lateinit var reminderManager: VitalReminderManager
    
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            reminderManager.scheduleVitalReminders()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        reminderManager = VitalReminderManager(this)
        android.util.Log.d("MainActivity", "Android version: ${Build.VERSION.SDK_INT}")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val hasPermission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
            
            android.util.Log.d("MainActivity", "Has notification permission: $hasPermission")
            
            if (!hasPermission) {
                android.util.Log.d("MainActivity", "Requesting notification permission...")
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            } else {
                android.util.Log.d("MainActivity", "Permission already granted, scheduling reminders")
                reminderManager.scheduleVitalReminders()
            }
        } else {
            android.util.Log.d("MainActivity", "Android < 13, no permission needed, scheduling reminders")
            reminderManager.scheduleVitalReminders()
        }
        
        setContent {
            Janitri_AssignmmentTheme {
                val viewModel: VitalLogViewModel = viewModel()
                VitalLogScreen(viewModel = viewModel)
            }
        }
    }
}