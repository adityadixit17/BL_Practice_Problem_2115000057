import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
public class Tester{
TimeOut t = new TimeOut();
@Test
@Timeout(value = 2, unit = TimeUnit.SECONDS)
void testLongRunningTask() throws InterruptedException {
t.longRunningTask();
}
}
