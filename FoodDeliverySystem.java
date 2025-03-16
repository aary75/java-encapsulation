// Creating the FoodDeliverySystem class to display the food item details

// Abstract class representing a food item
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice(); // Abstract method

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }

    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }
}

// Interface for discount functionality
interface Discountable {
    void applyDiscount(double percentage);
    void getDiscountDetails();
}

// VegItem class as subclass
class VegItem extends FoodItem implements Discountable {

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

   
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); 
    }

   
    public void applyDiscount(double percentage) {
        System.out.println("Discount of " + percentage + "% applied on Veg Item.");
    }

   
    public void getDiscountDetails() {
        System.out.println("Veg items have standard discount offers.");
    }
}

// NonVegItem class as subclass
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_SURCHARGE = 1.10; 

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * NON_VEG_SURCHARGE;
    }

    
    public void applyDiscount(double percentage) {
        System.out.println("Discount of " + percentage + "% applied on Non-Veg Item.");
    }

   
    public void getDiscountDetails() {
        System.out.println("Non-veg items have limited discount options.");
    }
}

// Main class
public class FoodDeliverySystem {
    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        System.out.println("Total Price: " + item.calculateTotalPrice());
    }

    public static void main(String[] args) {
        FoodItem vegItem = new VegItem("Paneer Butter Masala", 200, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Biryani", 300, 2);

        processOrder(vegItem);
        processOrder(nonVegItem);

        ((Discountable) vegItem).applyDiscount(10);
        ((Discountable) nonVegItem).applyDiscount(5);
    }
}


// Item: Paneer Butter Masala, Price: 200.0, Quantity: 2
// Total Price: 400.0
// Item: Chicken Biryani, Price: 300.0, Quantity: 2
// Total Price: 660.0
// Discount of 10.0% applied on Veg Item.
// Discount of 5.0% applied on Non-Veg Item.
