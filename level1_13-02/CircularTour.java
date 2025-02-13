import java.util.*;
public class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;
        int end = 1;
        int currentPetrol = pumps[start].petrol - pumps[start].distance;   
        while (end != start || currentPetrol < 0) {
            while (currentPetrol < 0 && start != end) {
                currentPetrol -= pumps[start].petrol - pumps[start].distance;
                start = (start + 1) % n; 
            }
            currentPetrol += pumps[end].petrol - pumps[end].distance;
            end = (end + 1) % n; 
        }
        return start;
    }
    public static void main(String[] args) {
        PetrolPump[] pumps = new PetrolPump[]{
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };   
        int start = findStartingPoint(pumps);
        System.out.println("The starting point for the circular tour is pump " + start);
    }
}
