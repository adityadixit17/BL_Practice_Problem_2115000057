public class Password{
String password;
public Password(String str){
password=str;
}
public boolean isValid(){
if(password.length()<8)return false;
if(!password.matches("*.[A-Z].*")) return false;
if(!password.matches(".*\\d.*")) return false;
return true;
}
}
