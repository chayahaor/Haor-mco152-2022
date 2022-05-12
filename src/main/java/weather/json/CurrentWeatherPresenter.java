package weather.json;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.CurrentWeatherFrame;

public class CurrentWeatherPresenter {
    private CurrentWeatherFrame view;
    private OpenWeatherMapService model;

    public CurrentWeatherPresenter(CurrentWeatherFrame view, OpenWeatherMapService model) {
        this.view = view;
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
        view.setTemp(degreesF);
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        view.showError();
    }

}
