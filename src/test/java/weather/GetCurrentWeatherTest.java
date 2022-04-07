package weather;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GetCurrentWeatherTest {


    @Test
    void getWeather() throws IOException {
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
        //when
        double temp = getCurrentWeather.currentWeather().getMaxTemperature();
        //then
        assertTrue(temp > 0);
    }

    @Test
    void getMaxTemp() throws IOException {
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
        //when
        double maxTemp = getCurrentWeather.currentWeather().getMaxTemperature();
        //then
        assertTrue(maxTemp > 0);
    }

    @Test
    void getMinTemp() throws IOException {
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
        //when
        double minTemp = getCurrentWeather.currentWeather().getMinTemperature();
        //then
        assertTrue(minTemp > 0);
    }

    @Test
    void getDescription() throws IOException {
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
        //when
        String description = getCurrentWeather.currentWeather().getDescription();
        //then
        assertNotNull(description);
    }

    @Test
    void getIcon() throws IOException {
        //given
        GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
        //when
        String icon = getCurrentWeather.currentWeather().getIcon();
        //then
        assertNotNull(icon);
    }
}