# FactApp — Random Cat Facts

An Android application demonstrating modern architecture and the latest Jetpack tools. This project was developed as a final assignment for the Mobile Development course.

## Tech Stack & Architecture

The app follows **Clean Architecture** principles and is decoupled into several modules to ensure scalability and testability:

* **Multi-module Architecture**:
    * `:app` — UI Layer (Jetpack Compose / Android Framework).
    * `:domain` — Business Logic (UseCases, Domain Models, Repository Interfaces).
    * `:data` — Data Layer (Retrofit API, Repository Implementations).
* **Dependency Injection**: **Hilt (Dagger)** for robust dependency management.
* **Networking**: **Retrofit + OkHttp** for handling API requests.
* **Asynchrony**: **Kotlin Coroutines** for non-blocking operations.

## Key Features

* **Build Variants & Flavors**: Configured `dev` and `prod` environments with distinct Package Names and Base URLs.
* **Deep Linking**: Support for external navigation via custom URI schemes.
* **Unit Testing**: Comprehensive test coverage for UseCases within the `:domain` module.

## How to Test Deeplink
You can test the deep link functionality by running the following command:
```bash
adb shell am start -W -a android.intent.action.VIEW -d "factapp://random"