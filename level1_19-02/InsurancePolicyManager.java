import java.util.*;
import java.time.*;
public class InsurancePolicyManager {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public List<Policy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        List<Policy> expiringSoon = new ArrayList<>();
        for (Policy policy : treeSetPolicies) {
            if (policy.expiryDate.isBefore(threshold)) {
                expiringSoon.add(policy);
            } else {
                break;
            }
        }
        return expiringSoon;
    }

    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.coverageType.equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }

    public Set<String> findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (!seen.add(policy.policyNumber)) {
                duplicates.add(policy.policyNumber);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        manager.addPolicy(new Policy("P123", "Aditya", LocalDate.now().plusDays(20), "Health", 500.0));
        manager.addPolicy(new Policy("P124", "Sachin", LocalDate.now().plusDays(40), "Auto", 300.0));
        manager.addPolicy(new Policy("P125", "Nikhil", LocalDate.now().plusDays(10), "Home", 700.0));
        manager.addPolicy(new Policy("P123", "Utkarsh", LocalDate.now().plusDays(20), "Health", 500.0));

        System.out.println("Policies expiring soon: " + manager.getPoliciesExpiringSoon());
        System.out.println("Health Policies: " + manager.getPoliciesByCoverageType("Health"));
        System.out.println("Duplicate Policies: " + manager.findDuplicatePolicies());
    }
}
class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return policyNumber + " - " + policyholderName + " (" + coverageType + ") - Expiry: " + expiryDate;
    }
}


