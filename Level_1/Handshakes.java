import java.util.*;
public class Handshakes{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int numberOfStudents=sc.nextInt();
double totalHandshakes= (numberOfStudents * (numberOfStudents - 1)) / 2 ;
System.out.print("Total possible handshakes is "+totalHandshakes);
}
}

