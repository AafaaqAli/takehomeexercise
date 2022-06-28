

## Working
This exercise demonstrates caching feature using RoomDB which is populated through API call only occur only
response when the application first launches or lastSyncTime is greater than 6 Hours.
### Ideal Implentation
Approach where I could have created a relay Server
which should have a recursive cron job that saves the response from GithubAPI and updates the data
every 3 hours, though which all of the users might have no limitations on API calls

## Architecture Patterns
- [Clean Code Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

## Design pattern
- [MVVM](https://developer.android.com/topic/libraries/architecture/viewmodel)


## Libraries

### UI
- [Lottie](https://github.com/airbnb/lottie-android)
- [Glide](https://github.com/bumptech/glide)
- [Swipe to refresh](https://developer.android.com/jetpack/androidx/releases/swiperefreshlayout)
- [Shimmer android](https://facebook.github.io/shimmer-android/)
- [SDP](https://github.com/intuit/ssp)
- [SDP](https://github.com/intuit/sdp)


### Network
- [Retrofit](https://square.github.io/retrofit/)
- [Gson](https://github.com/google/gson)

### Data
- [Room](https://developer.android.com/jetpack/androidx/releases/room)
- [Preference Data Store](https://developer.android.com/jetpack/androidx/releases/datastore)

### Dependency Injection
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android)

### UI controllers
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Navigation Component](https://developer.android.com/jetpack/androidx/releases/navigation)


## Versions
- [Android Studio Chipmunk | 2021.2.1]()
- [Gradle 7.3.3]()
- [CompileSDK 32]()
- [MinimumSDK 21]()
- [TargetSDK 32]()
