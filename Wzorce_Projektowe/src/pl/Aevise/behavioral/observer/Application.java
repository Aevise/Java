package pl.Aevise.behavioral.observer;

import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation(new ArrayList<>());
        Display display = new Display();

        weatherStation.registerObserver(display);
        weatherStation.setMeasurements(24, 65, 30.5f);

        weatherStation.removeObserver(display);
        weatherStation.setMeasurements(-2, 90, 29.2f);
    }
}
