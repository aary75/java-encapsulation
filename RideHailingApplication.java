// Abstract class representing a vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance); // Abstract method for fare calculation

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm);
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }
}

// Interface for GPS tracking
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car class extending Vehicle
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Bike class extending Vehicle
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Auto class extending Vehicle
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Main class
public class RideHailingApplication {
    public static void processRide(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.println("Fare for " + distance + " km: " + vehicle.calculateFare(distance));
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C101", "John Doe", 10);
        Vehicle bike = new Bike("B202", "Alice Smith", 5);
        Vehicle auto = new Auto("A303", "Bob Johnson", 7);

        processRide(car, 15);
        processRide(bike, 10);
        processRide(auto, 12);

        ((GPS) car).updateLocation("Downtown");
        ((GPS) bike).updateLocation("City Mall");
        ((GPS) auto).updateLocation("Bus Stand");
        
        System.out.println("Car Location: " + ((GPS) car).getCurrentLocation());
        System.out.println("Bike Location: " + ((GPS) bike).getCurrentLocation());
        System.out.println("Auto Location: " + ((GPS) auto).getCurrentLocation());
    }
}

// Vehicle ID: C101, Driver: John Doe, Rate per Km: 10.0
// Fare for 15.0 km: 150.0
// Vehicle ID: B202, Driver: Alice Smith, Rate per Km: 5.0
// Fare for 10.0 km: 50.0
// Vehicle ID: A303, Driver: Bob Johnson, Rate per Km: 7.0
// Fare for 12.0 km: 84.0
// Car Location: Downtown
// Bike Location: City Mall
// Auto Location: Bus Stand
