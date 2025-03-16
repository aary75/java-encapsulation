// Creating the class LibrarySystem to show the library items

// Abstract class showing the library items
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration(); // Abstract method for loan duration

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

// Interface for reservable items
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book class extending LibraryItem
class Book extends LibraryItem implements Reservable {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

   
    public int getLoanDuration() {
        return 30; // 1 month loan period
    }

    
    public void reserveItem() {
        System.out.println(" The book reserved safely.");
    }

   
    public boolean checkAvailability() {
        return true; // the book is available 
    }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14; // 2 weeks loan period
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 21; // 3 weeks loan period
    }

    public void reserveItem() {
        System.out.println("DVD reserved successfully.");
    }
   
    public boolean checkAvailability() {
        return true; // the DVD is available 
    }
}

// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        LibraryItem book = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald");
        LibraryItem magazine = new Magazine(2, "National Geographic", "Various");
        LibraryItem dvd = new DVD(3, "Inception", "Christopher Nolan");

        book.getItemDetails();
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");
        
        magazine.getItemDetails();
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days");
        
        dvd.getItemDetails();
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");
        
        ((Reservable) dvd).reserveItem();
        System.out.println("DVD Availability: " + ((Reservable) dvd).checkAvailability());
    }
}

// ID: 1, Title: The Great Gatsby, Author: F. Scott Fitzgerald
// Loan Duration: 30 days
// ID: 2, Title: National Geographic, Author: Various
// Loan Duration: 14 days
// ID: 3, Title: Inception, Author: Christopher Nolan
// Loan Duration: 21 days
// DVD reserved successfully.
// DVD Availability: true
