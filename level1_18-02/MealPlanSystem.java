import java.util.*;
interface MealPlan {
    String getPlanName();
}
class VegetarianMeal implements MealPlan {
    public String getPlanName() {
        return "Vegetarian Meal Plan";
    }
}
class VeganMeal implements MealPlan {
    public String getPlanName() {
        return "Vegan Meal Plan";
    }
}
class KetoMeal implements MealPlan {
    public String getPlanName() {
        return "Keto Meal Plan";
    }
}
class HighProteinMeal implements MealPlan {
    public String getPlanName() {
        return "High-Protein Meal Plan";
    }
}
class Meal<T extends MealPlan> {
    T mealPlan;   
    Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }
    void displayPlan() {
        System.out.println(mealPlan.getPlanName());
    }
}
class MealGenerator {
    static <T extends MealPlan> void generateMealPlan(T mealPlan) {
        System.out.println("Generated: " + mealPlan.getPlanName());
    }
}
public class MealPlanSystem {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = new Meal<>(new HighProteinMeal());       
        vegMeal.displayPlan();
        veganMeal.displayPlan();
        ketoMeal.displayPlan();
        proteinMeal.displayPlan();
        MealGenerator.generateMealPlan(new VegetarianMeal());
        MealGenerator.generateMealPlan(new VeganMeal());
        MealGenerator.generateMealPlan(new KetoMeal());
        MealGenerator.generateMealPlan(new HighProteinMeal());
    }
}
