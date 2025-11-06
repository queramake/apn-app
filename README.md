# APN Settings Launcher App

This is a native Android application that automatically opens the APN (Access Point Name) settings when launched, similar to the functionality provided in the original React Native code.

## Functionality

The app does the following:
1. Automatically launches the Android APN settings screen when the app starts
2. Provides a button to manually open the APN settings again if needed
3. Includes fallback to general settings if APN settings are not available on the device

## How It Works

The main functionality is implemented in `MainActivity.java`:
- When the app starts, it creates an Intent with action `android.intent.action.MAIN`
- Sets the class name to `com.android.settings.Settings$ApnSettingsActivity` to target the APN settings
- Includes error handling and fallback to general settings if APN settings are not accessible

## Project Structure

```
app/
├── src/main/
│   ├── java/com/apntest/MainActivity.java
│   ├── res/layout/activity_main.xml
│   └── AndroidManifest.xml
├── build.gradle
├── settings.gradle
└── README.md
```

## Build Instructions

To build and run this app:

1. Make sure you have Android Studio installed with the Android SDK
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Connect an Android device or start an emulator
5. Click "Run" to build and install the app

Alternatively, you can build from the command line:

```bash
# Build the project
./gradlew build

# Install on a connected device
./gradlew installDebug
```

## GitHub Actions CI/CD

This project includes a GitHub Actions workflow that automatically:
- Builds the Android project on every push/PR to main/master
- Runs tests
- Builds the debug APK
- Uploads the APK as an artifact for download

The workflow is defined in `.github/workflows/android-build.yml`

## Permissions

The app doesn't require special permissions as it simply launches system settings using Intents.

## Compatibility

- Minimum SDK: API level 21 (Android 5.0)
- Target SDK: API level 33 (Android 13)

Note: The app will only work on Android devices. The APN settings functionality is specific to Android and will not work on other platforms.