# APN Settings Shortcut

A simple Android app that acts as a shortcut to launch the APN settings screen on Android devices.

## How It Works

This app directly launches the APN settings activity (`com.android.settings.Settings$ApnSettingsActivity`) from the Android Settings app. When you tap the app icon, it will open the APN settings screen where you can configure Access Point Names.

## Building with GitHub Actions

This project is configured to build automatically using GitHub Actions. Here's how it works:

1. When you push changes to the `main` branch, GitHub Actions will automatically build the APK
2. The built APK will be available as a release asset
3. You can download the APK from the Releases tab

## Getting GitHub Token

The GitHub Actions workflow uses `GITHUB_TOKEN` which is automatically provided by GitHub. You don't need to create or configure anything - it's available by default in all workflows. The workflow is set up to use this token for creating releases.

## GitHub Actions Workflow

The workflow has been updated to use the latest versions of GitHub Actions:
- `actions/checkout@v4`
- `actions/setup-java@v4`
- `actions/upload-artifact@v4`
- `actions/download-artifact@v4`
- `softprops/action-gh-release@v2` (replaces deprecated release actions)

## Project Structure

The project includes the necessary Gradle wrapper files:
- `gradlew` - Unix/Mac executable gradle wrapper script
- `gradlew.bat` - Windows batch gradle wrapper script
- `gradle/wrapper/gradle-wrapper.properties` - Gradle wrapper properties file

## Build Process

The GitHub Actions workflow uses the Gradle setup action to properly configure Gradle for building the APK. This ensures that all necessary Gradle components are available during the build process.

## Compilation Fixes

The project has been updated with several fixes to ensure successful compilation:
- Updated MainActivity to extend AppCompatActivity for better compatibility
- Added necessary dependencies (appcompat and core libraries)
- Used a theme compatible with AppCompat
- Added proguard rules to prevent build issues
- Configured proper build settings for release builds

## Downloading the APK

To download the APK:

1. Go to the "Releases" tab in your GitHub repository
2. Find the latest release
3. Download the `apn-settings-shortcut.apk` file
4. Install it on your Android device (you may need to allow installation from unknown sources)

## Project Structure

- `app/src/main/AndroidManifest.xml` - App manifest with permissions and activities
- `app/src/main/java/com/apn/shortcut/MainActivity.java` - Main activity that launches the APN settings
- `app/build.gradle` - App build configuration
- `.github/workflows/build-release.yml` - GitHub Actions workflow for building and releasing

## Permissions

The app requires the `QUERY_ALL_PACKAGES` permission to check if the Settings app is available on the device.

## Compatibility

- Minimum SDK: 21 (Android 5.0)
- Target SDK: 34 (Android 14)