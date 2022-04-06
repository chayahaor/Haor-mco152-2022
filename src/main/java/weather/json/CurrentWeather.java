package weather.json;

public class CurrentWeather {
   public Main main;

   public double getTemperature(){
      return main.temp;
   }
}
