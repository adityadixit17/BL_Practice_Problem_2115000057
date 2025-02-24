import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
public class AnnotationProcessor{
public static void main(String [] args){
try{
Class<TaskManager> obj=TaskManager.class;
Method m=obj.getMethod("completeTask");
if(m.isAnnotationPresent(TaskInfo.class)) {
TaskInfo t = m.getAnnotation(TaskInfo.class);
System.out.println("Task Priority: " + t.priority());
System.out.println("Assigned To: " + t.assignedTo());
}
}
catch(Exception e){
System.out.println(e.getMessage());
}
}
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
String priority();
String assignedTo();
}
class TaskManager{
@TaskInfo(priority="high", assignedTo="Alice")
public void completeTask(){
System.out.println("Task in progression");
}
}
