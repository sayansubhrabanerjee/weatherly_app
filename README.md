# App Name: Weatherly

# OpenWeatherMap API: 

For getting APPID (secret key for weather api) we need to create an account and sign-in at: https://home.openweathermap.org/users/sign_in

# App Workflow:

After launching the app, we hit two API's:

1. For Current Weather data:  https://api.openweathermap.org/data/2.5/weather?id=1277333&units=metric&APPID=<your_appid>
2. For 5 days 3 hours Forecast Weather data:  https://api.openweathermap.org/data/2.5/forecast?id=1277333&units=metric&APPID=<your_appid>

# Happy Path or Success Case:

This can be thought of as a use case: Network Available

It will start fetching the data from server and display loading icon. This icon will be hidden after receiving the response and the header UI will be posted with current location, current temperature, current weather icon.
The footer part of the UI consists of a RecyclerView, which displays Forecast of the next 5 days 3 hour weather data, where each item consists of weather icon, date-time and respective temperature (in Celsius scale).
This list will be presented beautifully with slide up animation.

# Sad Path or Failure Case:

This can be thought of as a use case: No Network

User will be presented with an Error screen with a retry button.
If the user clicks on retry, it will show an alert dialog asking the user to turn-on Wi-Fi.
When the user clicks on Turn on button, the app will start fetching data from server again.

# Project Specifications:

Language: Kotlin </br>
Architecture: MVVM </br>
Network Calls: Retrofit, RxJava/RxAndroid </br>
Logging Network Calls: OkHttp/HttpLoggingInterceptor </br>
Image Processing: Glide </br>
Layout: ConstraintLayout </br>

# Improvement Areas or Tech-Debts:

1. This app uses hardcoded City Id for Bangalore (1277333). </br>
This could be improved by tracing the current location. App hits API if location permission is accepted otherwise app continues to run with limited functionalities.
2. In this app, while offline, user needs to turn-on Wi-Fi to get recent weather updates. </br>
This could be improved by caching data in Room database and showing the results during offline as well. This would provide seamless UX.
3. We can implement Google Paging Library to handle the weather forecast data more efficiently.

# YouTube: https://youtu.be/9Qj31_ChtEo
