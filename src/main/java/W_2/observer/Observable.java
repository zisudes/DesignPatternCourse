package W_2.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    public List<Observer> observers;

    public Observable(){
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        System.out.println("Removing observer: " + observer.getName());
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        this.observers.forEach(Observer::update);
    }
}