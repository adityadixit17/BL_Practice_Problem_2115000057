import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Tester{
DateFormat df=new DateFormat();
@Test
void testValidDate() {
assertEquals("25-12-2023",df.formatDate("2023-12-25"));
}
@Test
void testInvalidDate() {
assertNull(df.formatDate("invalid-date"));
}
@Test
void testEmptyDate() {
assertNull(df.formatDate(""));
}
}
