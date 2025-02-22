import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
class Testor{
DatabaseConnection db;
@BeforeEach
void setUp(){
db=new DatabaseConnection();
db.connect()
}
@AfterEach
void tearDown(){
db.disconnect();
}
@Test
void testConnectionEstablished(){
assertTrue(db.isConnected());
}
@Test
void testConnectionClosed(){
db.disconnect();
assertFalse(db.isConnected());
}
}
