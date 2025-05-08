package W_2.observer;

public class HotOrColdObserver extends Observer {
    public WeatherStation station;

    public HotOrColdObserver(WeatherStation station) {
        this.station = station;
    }

    public void update() {
        double temp = station.getTemperature();
        if (temp > 10) {
            System.out.println("It's Warm!");
        } else if (temp < -10){
            System.out.println("It's Cold!");
        }
    }

    public String getName() {
        return "Hot-or-Cold Observer";
    }
}