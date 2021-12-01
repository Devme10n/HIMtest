package GoodsDb;

import java.util.*;

public abstract class Subject {
    private final List <Observer > observers = new ArrayList<>();
    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }

    }
    interface Observer {
        void update();
    }
}
