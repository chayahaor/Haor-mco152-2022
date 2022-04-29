package weather;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GetCurrentWeatherTest {

    @Test
    void getWeather() {
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
        String zip = "10019";
        Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather(zip);

        //when
        double expectedTemp = observable.blockingFirst().getTemperature();
        double maxTemp = observable.blockingFirst().getMaxTemperature();
        double minTemp = observable.blockingFirst().getMinTemperature();

        //then
        assertTrue(expectedTemp>0);
        assertTrue(maxTemp>0);
        assertTrue(minTemp>0);



    }

}