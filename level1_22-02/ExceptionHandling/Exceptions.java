public class Exceptions{
public int divide(int a, int b){
if(b==0){
throw new ArithmeticException("cannot divide by zero");
}
return a/b;
}
}
