import java.util.*;
abstract class JobRole {
    String roleName;
    JobRole(String roleName) {
        this.roleName = roleName;
    }
    String getRoleName() {
        return roleName;
    }
}
class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }
}
class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }
}
class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager");
    }
}
class Resume<T extends JobRole> {
    T jobRole;   
    Resume(T jobRole) {
        this.jobRole = jobRole;
    }
    void processResume() {
        System.out.println("Processing resume for: " + jobRole.getRoleName());
    }
}
class ResumeScreeningSystem {
    static void screenResumes(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println("Screening resume for: " + role.getRoleName());
        }
    }
}
public class ResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager());       
        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();
        List<JobRole> jobRoles = Arrays.asList(new SoftwareEngineer(), new DataScientist(), new ProductManager());
        ResumeScreeningSystem.screenResumes(jobRoles);
    }
}
