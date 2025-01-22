
import java.util.*;
public class Height{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int heightCM=sc.nextInt();
double heightInches=heightCM*2.14;
int feet=heightInches/12;
double inches=heightInches%12;
System.out.println("Your Height in cm is "+heightCM+" while in feet is "+feet+" and 
inches is "+inches);
}
}


