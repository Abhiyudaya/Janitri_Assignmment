# Pregnancy Vitals Tracker

A comprehensive Android application for tracking pregnancy vitals with automated reminders and a beautiful Material Design 3 interface.

## 📱 Features

### Core Functionality
- **Vital Logging**: Track essential pregnancy vitals including:
  - Blood Pressure (Systolic/Diastolic)
  - Heart Rate (BPM)
  - Weight (kg)
  - Baby Kicks Count
- **Real-time Updates**: Instant UI updates using StateFlow
- **Data Persistence**: Local storage with Room Database
- **Automated Reminders**: WorkManager-powered notifications every 5 hours

### User Interface
- **Modern Design**: Material Design 3 with custom purple theme
- **Intuitive Navigation**: Clean, easy-to-use interface
- **Visual Cards**: Beautiful gradient cards displaying vital history
- **Responsive Layout**: Optimized for various screen sizes
- **Custom Icons**: PNG icons for each vital type

### Technical Features
- **MVVM Architecture**: Clean separation of concerns
- **Repository Pattern**: Centralized data management
- **Coroutines**: Asynchronous operations
- **Room Database**: Local SQLite database with type converters
- **WorkManager**: Background task scheduling for notifications
- **Jetpack Compose**: Modern declarative UI framework

## 🏗️ Architecture

### Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture Pattern**: MVVM (Model-View-ViewModel)
- **Database**: Room (SQLite)
- **Background Tasks**: WorkManager
- **State Management**: StateFlow
- **Dependency Injection**: Manual injection (no Hilt/Dagger)

### Project Structure
```
app/
├── src/main/java/com/example/janitri_assignmment/
│   ├── data/
│   │   ├── VitalLog.kt              # Entity model
│   │   ├── VitalLogDao.kt           # Database access object
│   │   ├── VitalLogDatabase.kt      # Room database
│   │   └── Converters.kt            # Type converters
│   ├── repository/
│   │   └── VitalLogRepository.kt    # Data repository
│   ├── viewmodel/
│   │   └── VitalLogViewModel.kt     # ViewModel for UI state
│   ├── ui/
│   │   └── VitalLogScreen.kt        # Main UI screen
│   ├── worker/
│   │   └── VitalReminderWorker.kt   # Background notification worker
│   ├── manager/
│   │   └── VitalReminderManager.kt  # WorkManager scheduler
│   └── MainActivity.kt              # Entry point
├── src/main/res/
│   ├── drawable/                    # PNG icons
│   ├── values/
│   │   ├── colors.xml              # Color resources
│   │   └── strings.xml             # String resources
│   └── AndroidManifest.xml         # App permissions and components
```

## 🎨 Design System

### Color Palette
- **Light Purple**: `#FFE6D9FF` - Card gradient top
- **Medium Purple**: `#FFD4B5FF` - Card gradient bottom  
- **Dark Purple**: `#FF9B59D0` - Primary actions, headers
- **Card Purple**: `#FFB794F4` - Accent color

### UI Components
- **Gradient Cards**: Purple gradient backgrounds for vital entries
- **Floating Action Buttons**: Primary (Add) and Test (Red) buttons
- **Material 3 Forms**: Outlined text fields with purple focus colors
- **Custom Icons**: Heart rate, blood pressure, weight, and baby icons

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24+ (Android 7.0)
- Kotlin 1.8+

### Installation
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run the app on device/emulator

### Permissions
The app requests the following permissions:
- `POST_NOTIFICATIONS` - For reminder notifications (Android 13+)
- `WAKE_LOCK` - For WorkManager background processing

## 📊 Database Schema

### VitalLog Entity
```kotlin
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
```

## 🔔 Notification System

### WorkManager Implementation
- **Periodic Reminders**: Every 5 hours
- **Notification Channel**: "Vital Reminders"
- **Deep Linking**: Tapping notification opens the app
- **Persistence**: Survives app restarts and device reboots

### Testing Notifications
- Red "TEST" button for immediate notification testing
- Debug logs for troubleshooting
- Runtime permission handling for Android 13+

## 🧪 Testing & Debugging

### Debug Features
- Comprehensive logging throughout the app
- Test notification button for immediate testing
- Permission status logging
- WorkManager execution logs

### Troubleshooting
1. **No Notifications**: Check notification permissions in device settings
2. **Permission Dialog**: Ensure Android 13+ for runtime permission requests
3. **WorkManager**: Check Logcat for "VitalReminderWorker" logs
4. **Database Issues**: Clear app data and restart

## 📝 Development Notes

### Key Implementation Details
- **StateFlow**: Reactive UI updates without LiveData
- **Type Converters**: Date serialization for Room database
- **Resource Management**: Colors defined in `colors.xml` for theme consistency
- **Error Handling**: Comprehensive validation in forms
- **Memory Management**: Proper lifecycle handling in ViewModels

### Future Enhancements
- Export data functionality
- Statistics and analytics
- Multiple user profiles
- Cloud synchronization
- Customizable reminder intervals

## 📄 License

This project is part of a Janitri assignment for Android development evaluation.

## 🤝 Contributing

This is an assignment project. Please refer to the requirements document for specific implementation guidelines.

---

**Built with ❤️ using Jetpack Compose and modern Android development practices**
