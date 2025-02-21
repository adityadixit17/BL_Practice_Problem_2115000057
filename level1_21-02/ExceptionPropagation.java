import java.util.*;
public class ExceptionPropagation{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
double amount=sc.nextDouble();
double rate=sc.nextDouble();
int years=sc.nextInt();
calculateInterest(amount,rate,years);
}
public static void calculateInterest(double amount, double rate, int years) throws IllegalArgumentException{
if(amount<0 || rate<0)
throw new IllegalArgumentException("amount or rate or years cannot be negative");
System.out.println(amount*rate*years*0.01);
}
}
