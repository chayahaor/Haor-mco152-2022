package weather;

import weather.dagger.DaggerCurrentWeatherComponent;
import weather.json.CurrentWeatherPresenter;
import weather.json.OpenWeatherMapService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@Singleton
public class CurrentWeatherFrame extends JFrame {
    private final JTextField zipCode;
    private final JButton submitButton;
    private final JLabel weather;
    OpenWeatherMapService model;
    CurrentWeatherPresenter presenter;

    @Inject
    public CurrentWeatherFrame(CurrentWeatherPresenter presenter) {
        this.presenter = presenter;
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
        presenter.loadWeatherFromZipcode(zipCode.getText());
    }


    public static void main(String[] args) {
        CurrentWeatherFrame frame = DaggerCurrentWeatherComponent.create().getCurrentWeatherFrame();
        frame.setVisible(true);
    }

    public void setTemp(double degreesF) {
        weather.setText(String.valueOf(degreesF));
    }

    public void showError() {
        weather.setText("Error");
    }
}
