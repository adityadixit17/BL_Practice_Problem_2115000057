import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class Tester{
BankAccount a;
@BeforeEach
void setUp(){
a=new BankAccount();
}
@Test
void testDeposit(){
a.deposit(100.0);
assertEquals(100.0,a.getBalance());
}
@Test
void testWithdraw(){
a.deposit(200.0);
a.withdraw(50.0);
assertEquals(150.0,a.getBalance());
}
@Test
void testWithdrawMoreThanBalance(){
a.deposit(100.0);
a.withdraw(150.0);
assertEquals(100.0,a.getBalance());
}
@Test
void testNegativeDeposit(){
account.deposit(-50.0);
assertEquals(0.0,a.getBalance());
}
}
