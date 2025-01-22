import java.util.*;
public class TemperaturConversion{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int celsius=sc.nextInt();
int farenheitResult=(celsius * (9/5)) + 32;
System.out.println("The "+celsius+" celsius is "+farenheitResult+" fahrenheit");
}
}

