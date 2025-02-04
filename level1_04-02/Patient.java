class Patient {
    private static String hospitalName = "City General Hospital";
    private static int totalPatients = 0;
    
    private final int patientID;
    private String name;
    private int age;
    private String ailment;
    
    // Constructor
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }
    
    // Static method to get total patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
    
    // Method to display patient details
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + this.patientID);
            System.out.println("Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Ailment: " + this.ailment);
        } else {
            System.out.println("Invalid patient object.");
        }
    }
    
    public static void main(String[] args) {
        Patient patient1 = new Patient(101, "Alice Johnson", 30, "Flu");
        Patient patient2 = new Patient(102, "Bob Smith", 45, "Migraine");
        
        patient1.displayPatientDetails();
        patient2.displayPatientDetails();
        
        getTotalPatients();
    }
}
