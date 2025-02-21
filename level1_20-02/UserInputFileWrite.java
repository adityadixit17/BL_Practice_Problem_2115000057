import java.io.*;
import java.util.*;
public class UserInputFileWrite{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
String name=sc.next();
int age=sc.nextInt();
String programmingLanguage=sc.next();
try(BufferedOutputStream bfo=new BufferedOutputStream(new FileOutputStream("output.txt",false))){
String data="Name: "+name+" Age: "+age+" programming Language: "+programmingLanguage;
bfo.write(data.getBytes(data));
bfo.flush();
} catch(Exception e){
System.out.println(e.getMessage());
}
}
}

