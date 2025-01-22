public class EarthVolume{
public static void main(String [] args){
int earthRadius=6378;
double volumeKM=(4/3)*3.14*earthRadius*earthRadius*earthRadius;
double earthRadiusMiles=6378*10.8;
double volumeMiles=(4/3)*3.14*earthRadiusMiles*earthRadiusMiles*earthRadiusMiles;
System.out.println("The volume of earth in cubic kilometers is "+volumeKM+" and cubic 
miles is "+volumeMiles);
}
}

