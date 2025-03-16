// Creating hte ecommerce Platform to display the rent of different vehicle
import java.util.List;
import java.util.ArrayList;

// Abstract Vehicle class
abstract class Vehicle{

    protected String vehicleNumber;
    protected String type;
    protected int rentalRate;

    public Vehicle(String vehicleNumber, String type, int rentalRate){
         this.vehicleNumber = vehicleNumber;
         this.type = type;
         this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getRentalRate() {
        return rentalRate;
    }

    public String getType() {
        return type;
    }

    public void setRentalRate(int rentalRate) {
         this.rentalRate = rentalRate;
    }

    // abstract method to calculate rent
    public abstract int calculateRentalCost(int days);
    
    // Display rent details
    public void displayRent(){
        System.out.println(getVehicleNumber() + " of type " + getType() + " has rent "+ getRentalRate());
    }
}

// Insurable interface
interface Insurable{

    double calculateInsurance();
    void getInsuranceDetails();
}

// Car class
class Car extends Vehicle implements Insurable{
    protected final int value; // value of car
    protected final double insuranceAmount = 0.05; // 5% of car value

    public Car(String vehicleNumber, String type, int rentalRate, int value){
         super(vehicleNumber, type, rentalRate);
         this.value = value;
    }

    public int getValue(){
         return value;
   }

    public int calculateRentalCost(int days){
          return rentalRate * days;
    }

    public double calculateInsurance(){
        return getValue() * insuranceAmount;
    }


    public void getInsuranceDetails(){
        this.displayRent();
        System.out.println("Insurance Cost: " + calculateInsurance());
    }
}

// Bike class
class Bike extends Vehicle implements Insurable{
    protected final int value; // value of bike
    protected final double insuranceAmount = 0.02; // 2% of bike value
 
    public Bike(String vehicleNumber, String type, int rentalRate, int value){
         super(vehicleNumber, type, rentalRate);
         this.value = value;
    }

    public int getValue() {
         return value;
    }

    public int calculateRentalCost(int days){
        return rentalRate * days;
    }

    public double calculateInsurance() {
       return getValue() * insuranceAmount;
    }

    public void getInsuranceDetails(){
        this.displayRent();
        System.out.println("Insurance Cost: " + calculateInsurance());
    }
}

// Truck class
class Truck extends Vehicle implements Insurable{
    protected final int value; // value of truck
    protected final double insuranceAmount = 0.10; // 10% of truck value

    public Truck(String vehicleNumber, String type, int rentalRate, int value){
         super(vehicleNumber, type, rentalRate);
         this.value = value;
    }

    public int getValue() {
         return value;
    }

    public int calculateRentalCost(int days){
        return rentalRate * days;
    }

    public double calculateInsurance() {
       return getValue() * insuranceAmount;
    }

    public void getInsuranceDetails(){
        this.displayRent();
        System.out.println("Insurance Cost " + calculateInsurance());
    }
}

// Main class
public class VehicleRentalSystem {
     public static void main(String[] args){
        List<Vehicle> vehicle = new ArrayList<>();

        Car car = new Car("HR23AQ4322", "Creta", 250, 100000);
        car.getInsuranceDetails();
        System.out.println("Rent of 5 days " + car.calculateRentalCost(5));


        Bike bike = new Bike("PB13AQ7286", "Bullet", 200, 50000);
        bike.getInsuranceDetails();
        System.out.println("Rent of 10 days " + bike.calculateRentalCost(10));


        Truck truck = new Truck("HR43AW5323", "Loader", 400,500000);
        truck.getInsuranceDetails();
        System.out.println("Rent of 15 days " + truck.calculateRentalCost(25));


       }
   }

// Output:
//HR23AQ4322 of type Creta has rent 250
// Insurance Cost: 5000.0
// Rent of 5 days 1250
// PB13AQ7286 of type Bullet has rent 200
// Insurance Cost: 1000.0
// Rent of 10 days 2000
// HR43AW5323 of type Loader has rent 400
// Insurance Cost 50000.0
// Rent of 15 days 10000

