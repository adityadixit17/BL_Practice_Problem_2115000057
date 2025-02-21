import java.util.*;
public class NestedException{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int [] arr=new int[n];
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
}
int index=sc.nextInt();
try{
int num=arr[index];
try{
int den=sc.nextInt();
System.out.println(num/den);
}
catch(ArithmeticException e){
System.out.println(e.getMessage());
}
}
catch(ArrayIndexOutOfBoundsException e) {
System.out.println("Please enter valid index");
}
}
}
