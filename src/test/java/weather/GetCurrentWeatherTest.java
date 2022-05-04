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

        //when
        CurrentWeather currentWeather = getCurrentWeather.getCurrentWeather("10019").blockingFirst();

        //then
        //Will fail if the temperature goes below 0
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > 0);


    }

}