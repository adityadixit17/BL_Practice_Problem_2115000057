import java.util.*;
public class UserDefinedException{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int age=sc.nextInt();
try{
checkAge(age);
System.out.println("Valid age");
}
catch(InvalidAgeException e){
System.out.println(e.getMessage());
}
}
public static void checkAge(int age) throws InvalidAgeException{
if(age<18)
throw new InvalidAgeException("Age is less than 18. Not valid");
}
}
class InvalidAgeException extends Exception{
public InvalidAgeException(String message){
super(message);
}
}
