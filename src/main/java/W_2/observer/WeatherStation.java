package W_2.observer;

public class WeatherStation extends Observable {
    public double temperature;

    public WeatherStation(){
        this.temperature = 0;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double newTemp){
        this.temperature = newTemp;
        this.notifyObservers();
    }

    public void increaseTemperature(double i) {
        if (temperature + i < 50) {
            setTemperature(temperature + i);
        } else {
            setTemperature(temperature - 1);
        }
    }

    public void decreaseTemperature(double i) {
        if (temperature - i > -50) {
            setTemperature(temperature - i);
        } else {
            setTemperature(temperature + 1);
        }
    }
}
