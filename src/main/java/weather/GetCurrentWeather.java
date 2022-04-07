package weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;

import java.io.IOException;

public class GetCurrentWeather {


    /**
     * @return the current temperature in Kelvin
     */
    public double getTemperature() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);
        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();

        return currentWeather.getTemperature();
    }

    public double getMaxTemp() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);
        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();
        return currentWeather.getMaxTemperature();
    }
    public double getMinTemp() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);
        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();
        return currentWeather.getMinTemperature();
    }

    public String getDescription() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);
        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();
        return currentWeather.getDescription();
    }

    public String getIcon() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenWeatherMapService service = retrofit.create(OpenWeatherMapService.class);
        CurrentWeather currentWeather = service.getCurrentWeather("10019")
                .execute()
                .body();
        return currentWeather.getIcon();
    }



}
