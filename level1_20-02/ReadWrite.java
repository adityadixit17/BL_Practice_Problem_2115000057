import java.io.*;
public class ReadWrite{
public static void main(String [] args){
try( FileInputStream fr=new FileInputStream("input.txt");
FileOutputStream fw=new FileOutputStream("output.txt")){
int bytes;
while((bytes=fr.read())!=-1){
fw.write(bytes);
}
System.out.println("File copied successfully");
} catch(IOException e){
System.out.println(e.getMessage());
}
}
}
