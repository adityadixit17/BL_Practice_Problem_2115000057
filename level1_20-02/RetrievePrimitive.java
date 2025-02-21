import java.io.*;
public class RetrievePrimitive{
public static void main(String [] args){
String path="students.dat";
try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(path))){
dos.writeInt(101);
dos.writeUTF("Aditya Dixit");
dos.writeDouble(3.85);
dos.writeInt(102);
dos.writeUTF("Piyush");
dos.writeDouble(3.92);
dos.writeInt(103);
dos.writeUTF("Sanjay");
dos.writeDouble(3.76);
System.out.println("Details saved successfully");
}
catch(IOException e){
System.out.println(e.getMessage());
}
try (DataInputStream dis=new DataInputStream(new FileInputStream(path))){
System.out.println("\nRetrieving Student Details:");
while (dis.available()>0){
int rollNumber=dis.readInt();
String name=dis.readUTF();
double gpa=dis.readDouble();
System.out.println("Roll No: "+rollNumber+", Name: "+name+", GPA: "+gpa);
}
}catch(IOException e){
System.out.println("Error reading from file: "+e.getMessage());
}
}
}
