public class UserRegistration {
public void registerUser(String username,String email,String password) {
if(username==null||username.isEmpty()||email==null||!email.contains("@")||password==null||password.length()<8) {
throw new IllegalArgumentException("Invalid input");
}
}
}
