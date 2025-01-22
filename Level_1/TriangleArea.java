import java.util.*;
public class TraingleArea{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
double base=sc.nextDouble();
double height=sc.nextDouble();
double areaCM=0.5*height*base;
double areaInches=areaCM/2.14;
System.out.println("Area in square cm is "+areaCM+" and in square inches is "
+areaInches);
}
}

