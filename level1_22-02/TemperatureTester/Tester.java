import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class Tester{
Temperature t=new Temperature();
@Test
void testCelsiusToFahrenheit() {
assertEquals(32.0,t.celsiusToFahrenheit(0),0.01);
assertEquals(212.0,t.celsiusToFahrenheit(100),0.01);
assertEquals(98.6,t.celsiusToFahrenheit(37),0.01);
}
@Test
void testFahrenheitToCelsius() {
assertEquals(0.0,t.fahrenheitToCelsius(32),0.01);
assertEquals(100.0,t.fahrenheitToCelsius(212),0.01);
assertEquals(37.0,t.fahrenheitToCelsius(98.6),0.01);
}
}
