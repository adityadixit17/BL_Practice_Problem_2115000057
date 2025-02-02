import java.util.*;
public class PersonDetails {
	private String name;
	private int age;
	public PersonDetails(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public PersonDetails(PersonDetails another) {
		this.name = another.name;
		this.age = another.age;	
	}
	public void Display() {
		System.out.println("NAME: " + name + ",AGE: " + age);
	}
	public static void main(String[] args) {
		PersonDetails person1 = new PersonDetails("Khushi", 22);
		person1.Display();
		PersonDetails person2 = new PersonDetails(person1);
		person2.Display();
	}
}
