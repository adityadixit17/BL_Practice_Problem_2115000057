import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class Tester{
UserRegistration ur=new UserRegistration();
@Test
void testValidRegistration() {
assertDoesNotThrow(() -> ur.registerUser("Krishna","krishna@gmail.com","password123"));
}
@Test
void testInvalidUsername() {
assertThrows(IllegalArgumentException.class,() -> ur.registerUser("","pooja@gmail.com","password123"));
}
@Test
void testInvalidEmail() {
assertThrows(IllegalArgumentException.class,() -> ur.registerUser("Khushi","khushi.com","password123"));
}
@Test
void testInvalidPassword() {
assertThrows(IllegalArgumentException.class,() -> ur.registerUser("Baibahvi","baibhavi@example.com","pass"));
}
}
