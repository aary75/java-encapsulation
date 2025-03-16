
// Abstract class representing a bank account

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
         if( amount > 0) {
             balance += amount;
             System.out.println("Deposited: " + amount);
         }
         else {
             System.out.println("Invalid deposit amount.");
         }
    }

     public void withdraw(double amount) {
            if(amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            }
            else {
                 System.out.println("Invalid withdrawal amount or insufficient balance.");
            }
     }

      public abstract void calculateInterest();

      public void displayBalance() {
            System.out.println("Balance: " + balance);
      }
 }

// Interface for loan-related functionality
interface Loanable{
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount class inheriting from BankAccount
class SavingsAccount extends BankAccount {
     private final double interest_rate = 0.04; 

     public SavingsAccount(String accountNumber, String holderName, double balance) {
          super(accountNumber, holderName, balance);
     }

     public void calculateInterest(){
         double interest = balance * interest_rate;
         balance += interest;
         System.out.println("Interest added: " + interest);
     }
}

// CurrentAccount class inheriting from BankAccount
class CurrentAccount extends BankAccount implements Loanable {
     private final double overdraft_limit = 5000;

     public CurrentAccount(String accountNumber, String holderName, double balance){
            super(accountNumber, holderName, balance);
     }

     public void calculateInterest() {
         System.out.println("No interest for Current account.");
     }

     public void applyForLoan(double amount){
          if(amount > 0){
             System.out.println("Loan application submitted for: " + amount);
          }
          else {
              System.out.println("Invalid loan amount.");
          }
     }

     public boolean calculateLoanEligibility() {
           return balance >= 1000; // simple eligibility condition
     }
}

// Demonstration class
public class BankingSystem {
     public static void main(String[] args){
         BankAccount savings = new SavingsAccount("F3242323", "Aaryan", 2000);
         BankAccount current = new CurrentAccount("C3234353", "Hitesh", 4000);

         savings.deposit(500);
         savings.calculateInterest();
         savings.displayBalance();

         current.withdraw(1000);
         current.calculateInterest();
         ((CurrentAccount) current).applyForLoan(2000);
          System.out.println("Loan eligibility: " + ((CurrentAccount) current).calculateLoanEligibility());
     }
}


// Deposited: 500.0
// Interest added: 100.0
// Balance: 2600.0
// Withdrawn: 1000.0
// No interest for Current account.
// Loan application submitted for: 2000.0
// Loan eligibility: true
