import java.lang.annotation.*;
import java.lang.reflect.*;
public class CustomAnnotationToDo{
public static void main(String [] args){
try{
Class<ProjectModule> obj=ProjectModule.class;
for (Method method : obj.getDeclaredMethods()) {
if (method.isAnnotationPresent(ToDo.class)) {
ToDo t = method.getAnnotation(ToDo.class);
System.out.println("Method: " + method.getName());
System.out.println("Task: " + t.task());
System.out.println("Assigned To: " + t.assignedTo());
System.out.println("Priority: " + t.priority());
System.out.println("-------------------------");
}
}
} catch(Exception e){
System.out.println(e.getMessage());
}
}
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ToDo{
String task();
String assignedTo();
String priority();
}
class ProjectModule{
@ToDo(task="Implement User Authentication", assignedTo="Krishna", priority="HIGH")
public void implementAuth(){
System.out.println("Implementing Authorization...");
}
@ToDo(task="Set up UserInterface", assignedTo="Palak", priority="MEDIUM")
public void SetUI(){
System.out.println("Setting up the UserInterface...");
}
@ToDo(task="Establish Connection with DB", assignedTo="Raghav", priority="HIGH")
public void connectDB(){
System.out.println("Establishing Connection with DataBase...");
}
}
