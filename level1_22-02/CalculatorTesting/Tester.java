import static org.junit.jupiter.Assertions;
import org.junit.jupiter.api.Test;
class Tester{
Claculator c=new Calculator();
@Test
void testAdd(){
assertEquals(14,c.add(8,6);
}
@Test
void testSubtract(){
assertEquals(2,c.subtract(8,6));
}
@Test
void testProduct(){
assertEquals(48,c.product(8,6));
}
@Test
void testDivide(){
assertEquals(4,c.divide(8,2));
}
@Test
void testDividebyZero(){
Exception exception = assertThrows(ArithmeticException.class,()->{
calculator.divide(6, 0);
});
assertEquals("Division by zero is not allowed", exception.getMessage());
}
}
