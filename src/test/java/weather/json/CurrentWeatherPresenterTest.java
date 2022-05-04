package weather.json;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import weather.CurrentWeatherFrame;
import weather.GetCurrentWeather;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CurrentWeatherPresenterTest {

    @BeforeAll
    static void beforeAllTests() {
        RxJavaPlugins.setIoSchedulerHandler((scheduler) -> Schedulers.trampoline());
        RxJavaPlugins.setNewThreadSchedulerHandler((scheduler) -> Schedulers.trampoline());
    }


    @Test
    void loadWeatherFromZipcode() {
        //given
        CurrentWeatherFrame view = mock(CurrentWeatherFrame.class);
        GetCurrentWeather model = mock(GetCurrentWeather.class);
        CurrentWeatherPresenter presenter = new CurrentWeatherPresenter(view, model);
        CurrentWeather currentWeather = mock(CurrentWeather.class);
        doReturn(100.0).when(currentWeather).getTemperature();
        doReturn(Observable.just(currentWeather))
                .when(model).getCurrentWeather("00000");


        //when
        presenter.loadWeatherFromZipcode("00000");


        //then
        verify(view).setTemp(100.0);

    }

}