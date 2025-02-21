import java.util.*;
public class MultipleCatch{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int [] arr=new int[n];
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
}
int index=sc.nextInt();
try{
System.out.println(arr[index]);
}
catch(ArrayIndexOutOfBoundsException e){
System.out.println("Invalid index!"+e.getMessage());
}
catch(NullPointerException e){
System.out.println("Array is not initialized!"+e.getMessage());
}
}
}
