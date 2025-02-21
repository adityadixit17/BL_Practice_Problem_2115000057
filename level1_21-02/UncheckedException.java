import java.util.*;
public class UncheckedException{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
try{
int num=sc.nextInt();
int den=sc.nextInt();
System.out.println(num/den);
} catch(ArithmeticException e){
System.out.println(e.getMessage());
} catch(InputMismatchException e){
System.out.println("Encountered Input Mismatch Exception "+e.getMessage());
}
}
}
