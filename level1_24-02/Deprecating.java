public class Deprecating{
public static void main(String [] args){
LegacyAPI la=new LegacyAPI();
la.oldFeature();
la.newFeature();
}
}
class LegacyAPI{
@Deprecated
public void oldFeature(){
System.out.println("This is the old Feature.");
}
public void newFeature(){
System.out.println("This is the new Feature.");
}
}
