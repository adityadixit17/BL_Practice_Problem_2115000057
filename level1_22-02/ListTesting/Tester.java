import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class Tester{
ListManager l=new ListManager();
@Test
public void testAdd(){
List<Integer> list=new ArrayList<>();
l.addElement(list,23);
assertTrue(list.contains(23));
}
public void testRemove(){
List<Integer> list=new ArrayList<>();
list.add(23);
list.add(45);
l.removeElement(list,23);
assertFalse(list.contains(23));
}
public void testGetSize(){
List<Integer> list=new ArrayList<>();
list.add(23);
list.add(45);
list.add(67);
assertEquals(3,l.getSize(list));
}
}
