package weather;

import weather.json.CurrentWeatherPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CurrentWeatherFrame extends JFrame {
    private final JTextField zipCode;
    private final JButton submitButton;
    private final JLabel weather;
    GetCurrentWeather getCurrentWeather = new GetCurrentWeather();
    CurrentWeatherPresenter presenter = new CurrentWeatherPresenter(this, getCurrentWeather);

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
        presenter.loadWeatherFromZipcode(zipCode.getText());
    }


    public static void main(String[] args) {
        JFrame frame = new CurrentWeatherFrame();
        frame.setVisible(true);
    }

    public void setTemp(double degreesF) {
        weather.setText(String.valueOf(degreesF));
    }

    public void showError() {
        weather.setText("Error");
    }
}
