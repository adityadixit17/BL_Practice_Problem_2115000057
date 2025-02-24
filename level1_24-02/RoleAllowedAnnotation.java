import java.lang.annotation.*;
import java.lang.reflect.*;
public class RoleAllowedAnnotation{
public static void main(String[] args){
SecureService service = new SecureService();
User admin = new User("ADMIN");
User guest = new User("GUEST");
service.execute(admin, "adminTask");
service.execute(guest, "adminTask");
}
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
String value();
}
class User {
private String role;
public User(String role){
this.role = role;
}
public String getRole(){
return role;
}
}
class SecureService {
@RoleAllowed("ADMIN")
public void adminTask(){
System.out.println("Admin task executed.");
}
public void execute(User user, String methodName){
try{
Method method = this.getClass().getMethod(methodName);
if (method.isAnnotationPresent(RoleAllowed.class)){
RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
if (!roleAllowed.value().equals(user.getRole())){
System.out.println("Access Denied!");
return;
}
}
method.invoke(this);
} catch (Exception e){
e.printStackTrace();
}
}
}
