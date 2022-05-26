package weather.dagger;

import dagger.Module;
import dagger.Provides;
import weather.json.OpenWeatherMapService;
import weather.json.OpenWeatherMapServiceFactory;

import javax.inject.Singleton;

@Module
public class CurrentWeatherModule {
    @Singleton
    @Provides
    public OpenWeatherMapService openWeatherMapService(OpenWeatherMapServiceFactory factory) {
        return factory.getInstance();
    }
}
