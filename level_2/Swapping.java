import java.util.*;
public class Swapping{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int number1=sc.nextInt();
int number2=sc.nextInt();
int temporary=number1;
number1=number2;
number2=temporary;
System.out.println("The swapped numbers are "+number1+" and "+number2);
}
}

