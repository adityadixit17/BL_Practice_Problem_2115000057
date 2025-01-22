import java.util.*;
public class TemperatureConversion{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int farenheit=sc.nextInt();
int celsiusResult= (farenheit-32) * (5/9) ;
System.out.println("The "+farenheit+" farenheit is "+celsiusResult+" Celsius");
}
}
