// Abstract class representing a patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill(); // Abstract method for billing

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

// Interface for managing medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient class extending Patient
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String medicalHistory;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.medicalHistory = "No records yet";
    }

    
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    
    public void addRecord(String record) {
        this.medicalHistory = record;
    }

    
    public void viewRecords() {
        System.out.println("Medical History: " + medicalHistory);
    }
}

// OutPatient class as subclass
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String diagnosis;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.diagnosis = "Not diagnosed yet";
    }

    
    public double calculateBill() {
        return consultationFee;
    }

   
    public void addRecord(String record) {
        this.diagnosis = record;
    }

    
    public void viewRecords() {
        System.out.println("Diagnosis: " + diagnosis);
    }
}

// Main class
public class HospitalPatientManagment {
    public static void processPatient(Patient patient) {
        patient.getPatientDetails();
        System.out.println("Total Bill: " + patient.calculateBill());
    }

    public static void main(String[] args) {
        Patient inPatient = new InPatient("P101", "Alice", 30, 5, 2000);
        Patient outPatient = new OutPatient("P202", "Bob", 25, 500);

        processPatient(inPatient);
        processPatient(outPatient);

        ((MedicalRecord) inPatient).addRecord("Recovered from surgery.");
        ((MedicalRecord) outPatient).addRecord("Diagnosed with flu.");
        
        ((MedicalRecord) inPatient).viewRecords();
        ((MedicalRecord) outPatient).viewRecords();
    }
}


// Patient ID: P101, Name: Alice, Age: 30
// Total Bill: 10000.0
// Patient ID: P202, Name: Bob, Age: 25
// Total Bill: 500.0
// Medical History: Recovered from surgery.
// Diagnosis: Diagnosed with flu.
