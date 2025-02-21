import java.util.*;
public class MethodPropagation{
public static void main(String [] args) throws Exception{
Scanner sc=new Scanner(System.in);
int num=sc.nextInt();
int den=sc.nextInt();
method2(num,den);
}
public static void method2(int num, int den) throws Exception{
method1(num,den);
}
public static void method1(int num, int den) throws Exception{
try{
System.out.println(num/den);
} catch(ArithmeticException e){
System.out.println(e.getMessage());
}
finally{
System.out.println("Operation Completed");
}
}
}
