import java.util.*;
public class FeeDiscount{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int totalFee=sc.nextInt();
int discountPercent=sc.nextInt();
int discount=(totalFee*discountPercent)/100;
int feePaid=totalFee-discount;
System.out.println("The discount amount is INR "+discount+" and final discounted fee is
INR "+feePaid);
}
}

