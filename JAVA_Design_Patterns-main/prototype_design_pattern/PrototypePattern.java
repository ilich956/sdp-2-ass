package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

class Vehicle implements Cloneable {  //create implementation of Cloneable for Vehicle
    //create list of vehicle
    private List<String> vehicleList;

    //constructor
    public Vehicle() {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    //void method to insert data
    public void insertData() {
        vehicleList.add("Honda amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    //getter
    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    //overriding method
    @Override
    public Object clone() throws CloneNotSupportedException {
        //creation of arraylist
        List<String> tempList = new ArrayList<String>();

        //for loop to add templist
        for (String s : this.getVehicleList()) {
            tempList.add(s);
        }

        return new Vehicle(tempList);
    }
}

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        //creation a object of vehicle
        Vehicle a = new Vehicle();
        a.insertData();

        Vehicle b = (Vehicle) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Honda new Amaze");

        //print out vehicle list
        System.out.println(a.getVehicleList());
        System.out.println(list);

        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
        System.out.println(a.getVehicleList());
    }

}