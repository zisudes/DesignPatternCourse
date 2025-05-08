package W_2.observer;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main implements Runnable {
    WeatherStation station;

    public WeatherStation getStation(){
        if (this.station == null){
            this.station = new WeatherStation();;
        }
        return this.station;
    }

    @Override
    public void run() {
        while (true) {
            getStation();
            Random r = new Random();

            try {
                Thread.sleep(r.nextInt(2000) + 1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
                System.exit(0);
            }
            if (r.nextBoolean()) {
                station.decreaseTemperature(r.nextDouble() * 6);
            } else {
                station.increaseTemperature(r.nextDouble() * 6);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of seconds to run the thread: ");
        int sec = scanner.nextInt();
        scanner.close();

        Main weatherRunnable = new Main();
        Thread thread = new Thread(weatherRunnable);
        WeatherStation stationObj = weatherRunnable.getStation();

        Observer w = new WeatherObserver(stationObj);
        stationObj.addObserver(w);
        Observer hotOrCold = new HotOrColdObserver(stationObj);
        stationObj.addObserver(hotOrCold);

        thread.start();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(sec + " seconds elapsed. Ending...");
                stationObj.removeObserver(w);
                stationObj.removeObserver(hotOrCold);
                thread.interrupt();
            }
        }, sec * 1000L);
    }
}