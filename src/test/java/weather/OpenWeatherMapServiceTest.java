package weather;

import org.junit.jupiter.api.Test;
import weather.json.CurrentWeather;
import weather.json.OpenWeatherMapService;
import weather.json.OpenWeatherMapServiceFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenWeatherMapServiceTest {

    @Test
    void getWeather() {
        //given
        OpenWeatherMapServiceFactory factory = new OpenWeatherMapServiceFactory();
        OpenWeatherMapService service = factory.getInstance();
        //when
        CurrentWeather currentWeather = service.getCurrentWeather("10019").blockingGet();

        //then
        //Will fail if the temperature goes below 0
        assertTrue(currentWeather.getTemperature() > 0);
        assertTrue(currentWeather.getMaxTemperature() > 0);
        assertTrue(currentWeather.getMinTemperature() > 0);


    }

}