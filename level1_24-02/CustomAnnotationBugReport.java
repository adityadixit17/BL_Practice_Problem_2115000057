import java.lang.annotation.*;
import java.lang.reflect.*;
public class CustomAnnotationBugReport{
public static void main(String [] args){
try {
Class<SoftwareModule> obj = SoftwareModule.class;
Method method = obj.getMethod("processData");
if (method.isAnnotationPresent(BugReports.class)) {
BugReports bugReports = method.getAnnotation(BugReports.class);
for (BugReport bug : bugReports.value()) {
System.out.println("Bug Report: " + bug.description());
}
}
} catch (NoSuchMethodException e) {
e.printStackTrace();
}
}
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
BugReport[] value();
}
class SoftwareModule{
@BugReport(description="Null pointer exception at invalid input")
@BugReport(description="performance issue in large data processing")
public void processData(){
System.out.println("Data under processing");
}
}
