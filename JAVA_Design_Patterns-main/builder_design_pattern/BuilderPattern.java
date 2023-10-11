package builder_design_pattern;

class Vehicle {
    private String engine;
    private int wheel;
    private int airbags;

    //getter getEngine()
    public String getEngine() {
        return this.engine;
    }

    //getter getWheel()
    public int getWheel() {
        return this.wheel;
    }

    //getter getAirbags()
    public int getAirbags() {
        return this.airbags;
    }

    //private constructor
    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    //class for building VehicleBuilder()
    public static class VehicleBuilder {
        private String engine;
        private int wheel;
        private int airbags;

        //constructor
        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        //setter setAirbags()
        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        //method to build Vehicle
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {

        //create car with engine1500cc, 4 wheels, 4 airbags
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

        //create bike with 250cc engine, 2 wheels
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();


        //print out results
        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }
}