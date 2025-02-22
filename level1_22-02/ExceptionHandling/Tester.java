import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class Tester{
Exceptions e=new Exceptions();
@Test
void testDivideByZero() {
assertThrows(ArithmeticException.class,()->e.divide(10, 0));
}
}
