package W_2.observer;

public class WeatherObserver extends Observer {
    public WeatherStation station;

    public WeatherObserver(WeatherStation station) {
        this.station = station;
    }

    public void update() {
        System.out.printf("Weather updated! Current weather: %.2f°C\n", station.getTemperature());
    }

    public String getName() {
        return "Weather Observer";
    }
}