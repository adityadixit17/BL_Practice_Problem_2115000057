public class Overriding{
public static void main(String [] args){
Animal ad=new Dog();
ad.makeSound();
}
}
class Animal{
public void makeSound(){
System.out.println("animal is making the sound");
}
}
class Dog extends Animal{
@Override
public void makeSound(){
System.out.println("Dog is making the sound");
}
}
