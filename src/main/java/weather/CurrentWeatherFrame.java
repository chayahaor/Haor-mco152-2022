package weather;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import weather.json.CurrentWeather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CurrentWeatherFrame extends JFrame {
    private JTextField zipCode;
    private JButton submitButton;
    private JLabel weather;
    JPanel verticalPanel;
    GetCurrentWeather getCurrentWeather = new GetCurrentWeather();

    public CurrentWeatherFrame() {

        setTitle("Current Weather");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());


        zipCode = new JTextField();
        add(zipCode);

        submitButton = new JButton();
        submitButton.setText("Submit Zip Code");
        submitButton.addActionListener(this::onSubmitClicked);
        add(submitButton);

        weather = new JLabel();
        add(weather);

    }

    public void onSubmitClicked(ActionEvent event) {
        Observable<CurrentWeather> observable = getCurrentWeather.getCurrentWeather(zipCode.getText());
        Disposable disposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(this::onNext, this::onError);

    }

    public void onNext(CurrentWeather currentWeather) {
        double degreesF = currentWeather.getTemperature();
        weather.setText(String.valueOf(degreesF));
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    public static void main(String[] args) {
        JFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }

}
