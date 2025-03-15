// Creating hte ecommerce Platform to display the price of different items
import java.util.List;
import java.util.ArrayList;

// Abstract Product class
abstract class Product{

    protected int productId;
    protected String name;
    protected int price;

    public Product(int productId, String name, int price){
         this.productId = productId;
         this.name = name;
         this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public int getprice() {
        return price;
    }

    public void setPrice(int price) {
         this.price = price;
    }

    // abstract method for discoun calculation
    public abstract double calculateDiscount();
    
    // Display product details
    public void displayProduct(){
        System.out.print(getName() + " with product id " + getProductId() + " is selling at "+ getprice());
    }
}

// Taxable interface
interface Taxable{

    double calculateTax();
    void getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable{
    protected final double discount = 0.10; // 10% discount
    protected final double tax = 0.18; // 18% tax

    public Electronics(int productId, String name, int price){
         super(productId, name, price);
    }

    public double calculateDiscount(){
        return getprice() * discount;
    }

    public double calculateTax() {
       return getprice() * tax;
    }

    public void getTaxDetails(){
        System.out.println(getName() + " is selling at 18% tax");
    }
}

// Clothing class
class Clothing extends Product implements Taxable{
    protected final double discount = 0.13; // 13% discount
    protected final double tax = 0.20; // 20% tax
 
    public Clothing(int productId, String name, int price){
         super(productId, name, price);
    }

    public double calculateDiscount(){
        return getprice() * discount;
    }

    public double calculateTax() {
       return getprice() * tax;
    }

    public void getTaxDetails(){
        System.out.println(getName() + " is selling at 20% tax");
    }
}

// Groceries class
class Groceries extends Product implements Taxable{
    protected final double discount = 0.15; // 15% discount
    protected final double tax = 0.25; // 25% tax

    public Groceries(int productId, String name, int price){
         super(productId, name, price);
    }

    public double calculateDiscount(){
        return getprice() * discount;
    }

    public double calculateTax() {
       return getprice() * tax;
    }

    public void getTaxDetails(){
        System.out.println(getName() + " is selling at 18% tax");
    }
}

// Main class
public class eCommercePlatform {
     public static void main(String[] args){
        List<Product> products = new ArrayList<>();

        Product product1 = new Electronics(1, "Mobile", 25000);
        products.add(product1);

        Product product2 = new Clothing(2, "Trouser", 2000);
        products.add(product2);

        Product product3 = new Groceries(3, "Cheese", 400);
        products.add(product3);

        // Display all products and final prices
        for(Product product : products) {
           product.displayProduct();
           double tax = (product instanceof Taxable) ? ((Taxable ) product).calculateTax() : 0;
           double discount =  product.calculateDiscount();
           double finalPrice = product.getprice() + tax - discount;

           System.out.println("Discount: $" + discount + " | Tax: $" + tax);
           System.out.println("Final Price: $" + finalPrice);
       }
   }
}

// Output:
// Mobile with product id 1 is selling at 25000Discount: $2500.0 | Tax: $4500.0
// Final Price: $27000.0
// Trouser with product id 2 is selling at 2000Discount: $260.0 | Tax: $400.0
// Final Price: $2140.0
// Cheese with product id 3 is selling at 400Discount: $60.0 | Tax: $100.0
// Final Price: $440.0














