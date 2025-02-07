class Animal {
    String name;
    int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void makeSound() {
        System.out.println("Some animal sound");
    }
}
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    public void makeSound() {
        System.out.println("Bark");
    }
}
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    public void makeSound() {
        System.out.println("Meow");
    }
}
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }
    public void makeSound() {
        System.out.println("Chirp");
    }
}
public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal dog = new Dog("Jacky", 4);
        Animal cat = new Cat("Biloti", 1);
        Animal bird = new Bird("Coco", 1);
	System.out.print(dog.name + " "); dog.makeSound();
        System.out.print(cat.name + " "); cat.makeSound();
	System.out.print(bird.name + " "); bird.makeSound();
    }
}
