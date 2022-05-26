package weather.json;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface OpenWeatherMapService {
    public static final String APPID = "4163963fcf3d2544257c752ef8c279e9";

    @GET("data/2.5/weather?appid=" + APPID + "&units=imperial")
    Single<CurrentWeather> getCurrentWeather(@Query("q") String zipcode);

}
