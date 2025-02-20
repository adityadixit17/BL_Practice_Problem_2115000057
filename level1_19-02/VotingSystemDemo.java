import java.util.*;

public class VotingSystemDemo {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.castVote("Aditya");
        votingSystem.castVote("Nikhil");
        votingSystem.castVote("Sachin");
        votingSystem.castVote("utkarsh");
        votingSystem.castVote("Anubhav");
        votingSystem.castVote("Kunal");

        votingSystem.displayVotesInOrder();
        votingSystem.displaySortedVotes();
    }
}
class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteMap.get(candidate));
        sortedVotes.put(candidate, voteMap.get(candidate));
    }

    public void displayVotesInOrder() {
        System.out.println("Votes in order of casting:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displaySortedVotes() {
        System.out.println("Votes in sorted order:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}


