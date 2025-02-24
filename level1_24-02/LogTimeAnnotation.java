import java.lang.annotation.*;
import java.lang.reflect.*;
public class LogTimeAnnotation{
public static void main(String[] args) throws Exception{
TestClass obj = new TestClass();
ExecutionTimeLogger.runAnnotatedMethods(obj);
}
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{}
class ExecutionTimeLogger{
static void runAnnotatedMethods(Object obj) throws Exception{
for (Method method : obj.getClass().getDeclaredMethods()){
if (method.isAnnotationPresent(LogExecutionTime.class)){
long start = System.nanoTime();
method.invoke(obj);
long end = System.nanoTime();
System.out.println(method.getName() + " executed in " + (end - start) + " ns");
}
}
}
}
class TestClass{
@LogExecutionTime
void methodOne(){
for (int i = 0; i < 1000000; i++);
}
@LogExecutionTime
void methodTwo(){
for (int i = 0; i < 500000; i++);
}
@LogExecutionTime
void methodThree(){
for (int i = 0; i < 2000000; i++);
}
}
