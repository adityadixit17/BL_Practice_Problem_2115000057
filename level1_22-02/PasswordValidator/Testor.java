import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class Testor{
Password p1=new Password("StrongP@aaa1");
Password p2=new Password("Short1");
Password p3=new Password("weakpassword1");
Password p3=new Password("NoDigitsHere");
@Test
void testValidPassword() {
assertTrue(p1.isValid());
}
@Test
void testShortPassword() {
assertFalse(p2.isValid());
}
@Test
void testNoUppercase() {
assertFalse(p3.isValid());
}
@Test
void testNoDigit() {
assertFalse(p4.isValid());
}
}
