package factory_design_pattern;

//creation of abstract class Vehicle
abstract class Vehicle {
    public abstract int getWheel();

    //toString method
    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

//child class Car of parent class Vehicle
class Car extends Vehicle {
    int wheel;

    Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

//child class Bike of parent class Vehicle
class Bike extends Vehicle {
    int wheel;

    //constructor
    Bike(int wheel) {
        this.wheel = wheel;
    }


    //getter getWheel()
    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel) {
        //if type equals car return Car(wheel)
        if (type == "car") {
            return new Car(wheel);
        }
        //if type equals bike return Bike(wheel)
        else if (type == "bike") {
            return new Bike(wheel);
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        //print out wheels of car
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        //print out wheels of bike
        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }
}