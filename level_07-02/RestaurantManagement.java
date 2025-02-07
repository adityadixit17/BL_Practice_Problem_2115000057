interface Worker {
    void performDuties();
}
class Person {
    String name;
    int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }
    public void performDuties() {
        System.out.println(getName() + " is cooking.");
    }
}
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }
    public void performDuties() {
        System.out.println(getName() + " is serving food.");
    }
}
public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("John", 1);
        Waiter waiter = new Waiter("Alice", 2);
        chef.performDuties();
        waiter.performDuties();
    }
}
