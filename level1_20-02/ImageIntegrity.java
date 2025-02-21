import java.io.*;
import java.util.*;
public class ImageIntegrity{
public static void main(String [] args) throws IOException{
String inputImage="input.png";
String outputImage="output.png";
byte[] imageArray=readImageToArray(inputImage);
writeArrayToImage(outputImage,imageArray);
boolean decision=compare(inputImage,outputImage);
System.out.println(decision);
}
public static byte[] readImageToArray(String path) throws IOException{
File f=new File(path);
try(FileInputStream fis=new FileInputStream(f);
ByteArrayOutputStream b=new ByteArrayOutputStream()){
byte[] buffer=new byte[4096];
int bread;
while((bread=fis.read(buffer))!=-1){
b.write(buffer,0,bread);
}
return b.toByteArray();
}
}
public static void writeArrayToImage(String path, byte [] array) throws IOException{
try(ByteArrayInputStream b=new ByteArrayInputStream(array);
FileOutputStream f=new FileOutputStream(path)){
byte [] buffer=new byte[4096];
int bread;
while((bread=b.read(buffer))!=-1){
f.write(buffer,0,bread);
}
}
}
public static boolean compare(String input, String output) throws IOException{
byte[] inputArray=readImageToArray(input);
byte[] outputArray=readImageToArray(output);
return Arrays.equals(inputArray,outputArray);
}
}
