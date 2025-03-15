// Creating the EmployeeManagementSystem class to get employee details
import java.util.ArrayList;
import java.util.List;

// Anstract class Employee
abstract class Employee{
     private int employeeId;
     private String name;
     private double baseSalary;

     public Employee(int employeeId, String name, double baseSalary){
             this.employeeId = employeeId;
             this.name = name;
             this.baseSalary = baseSalary;
     }

     public int getEmployeeId(){
          return employeeId;
     }

     public String getName(){
          return name;
     }

     public double getBaseSalary() {
          return baseSalary;
     }

     public abstract double calculateSalary();
     
     public void displayDetails() {
          System.out.println("Employee ID: " + employeeId);
          System.out.println("Name: " + name);
          System.out.println("Salary: " + calculateSalary());
     }
}

// interface Department
interface Department{
      void assignDepartment(String department);
      String getDepartmentDetails();
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee implements Department {
       private String department;

       public FullTimeEmployee(int employeeId, String name, double baseSalary) {
            super(employeeId, name, baseSalary);
       }

       public double calculateSalary() {
           return getBaseSalary(); // Fixed salary for full-time employees
       }

      public void assignDepartment(String department){
            this.department = department;
      }

      public String getDepartmentDetails() {
           return "Department:" + department;
      }
 }

// PartTImeEmployees class
 class PartTimeEmployee extends Employee implements Department {
      private int hoursWorked;
      private double hourlyRate;
      private String department;

     public PartTimeEmployee(int employeeId, String name, double hourlyRate, int houseWorked) {
          super(employeeId, name, 0); // Base salary is not fixed for part-time enployees
          this.hourlyRate = hourlyRate;
          this.hoursWorked = hoursWorked;
     }

     public double calculateSalary() {
        return hourlyRate * hoursWorked; // Salary based on hours worked
     }

     public void assignDepartment(String department){
        this.department = department;
     }

     public String getDepartmentDetails(){
           return "Department:" + department;
     }
}

// Main class to test the functionality
public class EmployeeManagementSystem{
     public static void main(String[] args){

         List<Employee> employees = new ArrayList<>();

         FullTimeEmployee emp1 = new FullTimeEmployee(1, "Aaryan", 40000);
         emp1.assignDepartment("Public Dealing");
         employees.add(emp1);

         PartTimeEmployee emp2 = new PartTimeEmployee(2, "Hitesh", 30, 100);
         emp2.assignDepartment("Technical");
         employees.add(emp2);

         for (Employee emp : employees) {
            emp.displayDetails();
             if( emp instanceof Department){
                 System.out.println(((Department) emp).getDepartmentDetails());
             }

             System.out.println();
        }
     }
  }


// Employee ID: 1
// Name: Aaryan
// Salary: 40000.0
// Department:Public Dealing

// Employee ID: 2
// Name: Hitesh
// Salary: 0.0
// Department:Technical














































