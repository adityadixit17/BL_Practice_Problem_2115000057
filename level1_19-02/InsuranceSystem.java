import java.time.LocalDate;
import java.util.*;
public class InsuranceSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy("P123", "Aditya", LocalDate.now().plusDays(10));
        manager.addPolicy("P124", "Nikhil", LocalDate.now().plusDays(25));
        manager.addPolicy("P125", "Sachin", LocalDate.now().plusDays(5));
        manager.addPolicy("P126", "Utkarsh", LocalDate.now().plusDays(40));
        
        System.out.println("Policy P123: " + manager.getPolicy("P123"));
        System.out.println("Policies expiring in next 30 days: " + manager.getPoliciesExpiringSoon(30));
        System.out.println("Policies for John Doe: " + manager.getPoliciesByHolder("John Doe"));
        
        manager.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + manager.getPoliciesExpiringSoon(60));
    } 
  }
class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyHolder='" + policyHolder + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

class InsurancePolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>();
    private LinkedHashMap<String, Policy> orderedPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> policiesByExpiry = new TreeMap<>();

    public void addPolicy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        Policy policy = new Policy(policyNumber, policyHolder, expiryDate);
        policyMap.put(policyNumber, policy);
        orderedPolicies.put(policyNumber, policy);
        policiesByExpiry.computeIfAbsent(expiryDate, k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon(int days) {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(days);
        List<Policy> expiringSoon = new ArrayList<>();
        for (Map.Entry<LocalDate, List<Policy>> entry : policiesByExpiry.headMap(threshold, true).entrySet()) {
            expiringSoon.addAll(entry.getValue());
        }
        return expiringSoon;
    }

    public List<Policy> getPoliciesByHolder(String policyHolder) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(policyHolder)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        policiesByExpiry.headMap(today, true).clear();
        policyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
        orderedPolicies.values().removeIf(policy -> policy.expiryDate.isBefore(today));
    }
}



