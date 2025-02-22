import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class Tester{
CheckEven ce=new CheckEven();
@Test
public void checkIsEven(){
assertsEquals(true.ce.isEven(6));
assertsEquals(true.ce.isEven(2));
assertsEquals(true.ce.isEven(4));
assertsEquals(false.ce.isEven(7));
assertsEquals(false.ce.isEven(9));
}
}
