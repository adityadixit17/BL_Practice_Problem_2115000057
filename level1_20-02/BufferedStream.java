import java.io.*;
public class BufferedStream{
public static void main(String [] args){
long btime=Buffer();
long ftime=FileRead();
if(btime>ftime){
System.out.println("Buffered Reader is more efficient than File Reader.");
}
else
System.out.println("File Reader is more efficient than Buffered Reader.");
}
public static long Buffer(){
long start=System.nanoTime();
try(BufferedInputStream bfi=new BufferedInputStream(new FileInputStream("input.txt"));
BufferedOutputStream bfo=new BufferedOutputStream(new FileOutputStream("output.txt"))){
byte buffer[]=new byte[4096];
int bread;
while((bread=bfi.read(buffer))!=-1){
bfo.write(buffer,0,bread);
}
} catch(Exception e){
System.out.println(e.getMessage());
}
long end=System.nanoTime();
return end-start;
}
public static long FileRead(){
long start=System.nanoTime();
try(FileInputStream fis=new FileInputStream("input.txt");
FileOutputStream fos=new FileOutputStream("output.txt")){
byte buffer[]=new byte[4096];
int fread;
while((fread=fis.read(buffer))!=-1){
fos.write(buffer,0,fread);
}
} catch(Exception e){
System.out.println(e.getMessage());
}
long end=System.nanoTime();
return end-start;
}
}
