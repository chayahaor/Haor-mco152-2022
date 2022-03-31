package weather;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GetCurrentWeather {

    /**
     * @return the current temperature in Kelvin
     */
    public double getTemperature() throws IOException {
        URL url = new URL("https://samples.openweathermap.org/data/2.5/weather?zip=10019,us&appid=b6907d289e10d714a6e88b30761fae22");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line = reader.readLine();
        System.out.println(line);
        return 0;
    }




}
