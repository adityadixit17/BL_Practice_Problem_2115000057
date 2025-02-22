import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test;
public class Tester{
StringUtils su=new StringUtils();
@Test
public void testReverse(){
assertsEquals("dcba",su.reverse("abcd"));
assertsEquals("naman",su.reverse("naman"));
assertsEquals("",su.reverse(""));
}
@Test
public void testPalindrome(){
assertsEquals(false,su.isPalindrome("abcd"));
assertsEquals(true,su.isPalindrome("naman"));
assertsEquals(true,su.isPalindrome(""));
}
@Test
public void testToUpperCase(){
assertsEquals("ABCD",su.toUpperCase("abcd"));
assertsEquals("NAMAN",su.toUpperCase("naman"));
assertsEquals("",su.toUpperCase(""));
}
}

