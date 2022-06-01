package weather.json;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.CurrentWeatherFrame;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class CurrentWeatherPresenter {
    private Provider<CurrentWeatherFrame> viewProvider;
    private OpenWeatherMapService model;

    @Inject
    public CurrentWeatherPresenter(
            Provider<CurrentWeatherFrame> viewProvider,
            OpenWeatherMapService model) {
        this.viewProvider = viewProvider;
        this.model = model;

    }

    public void loadWeatherFromZipcode(String zipcode) {
        Disposable disposable = model.getCurrentWeather(zipcode)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(this::onNext, this::onError);

    }

    public void onNext(CurrentWeather currentWeather) {
        double degreesF = currentWeather.getTemperature();
        viewProvider.get().setTemp(degreesF);
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        viewProvider.get().showError();
    }

}
