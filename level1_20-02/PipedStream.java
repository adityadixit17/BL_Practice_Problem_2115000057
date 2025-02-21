import java.io.*;
public class PipedStreamExample{
public static void main(String[] args)throws IOException{
PipedOutputStream pos=new PipedOutputStream();
PipedInputStream pis=new PipedInputStream(pos);
WriterThread writer=new WriterThread(pos);
ReaderThread reader=new ReaderThread(pis);
writer.start();
reader.start();
}
}
class WriterThread extends Thread{
PipedOutputStream pos;
WriterThread(PipedOutputStream pos){this.pos=pos;}
public void run(){
try{
pos.write("Message from WriterThread".getBytes());
pos.close();
}catch(IOException e){System.out.println(e.getMessage());}
}
}
class ReaderThread extends Thread{
PipedInputStream pis;
ReaderThread(PipedInputStream pis){this.pis=pis;}
public void run(){
try{
int data;
while((data=pis.read())!=-1)System.out.print((char) data);
pis.close();
}catch(IOException e){System.out.println(e.getMessage());}
}
}

