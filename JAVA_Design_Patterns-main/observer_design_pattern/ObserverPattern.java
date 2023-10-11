package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;


//create interface Subject
interface Subject {
    //create void methods without body
    void register(Observer obj);

    void unregister(Observer obj);

    void notifyObservers();
}

class DeliveryData implements Subject  //create implementation of Subject for DeliveryData
{
    private List<Observer> observers;
    private String location;

    //public constructor
    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    //overriding method register
    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    //overriding method unregister
    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    //overriding method notifyObservers()
    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location);
        }
    }

    //method for location changed
    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    //getter method
    public String getLocation() {
        return "YPlace";
    }
}


interface Observer //creation of interface observer
{
    public void update(String location);
}


class Seller implements Observer   //create implementation of Observer for Seller
{
    private String location;


    //overriding void method
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    //void method to show location
    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

class User implements Observer   //create implementation of Observer for User
{
    private String location;

    //void method update
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    //void method to show location
    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

class DeliveryWarehouseCenter implements Observer   //create implementation of Observer for DeliveryWarehouseCenter
{
    private String location;

    //void method
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    //void method to show location
    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData();

        //creation of objects
        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        //method calling
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        topic.locationChanged();
        topic.unregister(obj3);

        System.out.println();
        topic.locationChanged();
    }
}