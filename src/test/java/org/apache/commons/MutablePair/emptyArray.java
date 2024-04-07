import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;

class emptyArrayTest {

  @Test
  void testEmptyArray() {
    MutablePair<?, ?>[] emptyArray = MutablePair.emptyArray();
    assertNotNull(emptyArray);
    assertEquals(0, emptyArray.length);
  }
  
  @Test
  void testEmptyArrayWithGenericType() {
    MutablePair<String, Integer>[] emptyArray = MutablePair.emptyArray();
    assertNotNull(emptyArray);
    assertEquals(0, emptyArray.length);
  }
  
  @Test
  void testEmptyArrayWithDifferentTypes() {
    MutablePair<String, Integer>[] emptyArray = MutablePair.emptyArray();
    MutablePair<Integer, String>[] emptyArray2 = MutablePair.emptyArray();
    assertNotNull(emptyArray);
    assertNotNull(emptyArray2);
    assertEquals(0, emptyArray.length);
    assertEquals(0, emptyArray2.length);
  }
  
  @Test
  void testEmptyArrayWithMap() {
    MutablePair<Map<String, Integer>, Map<Integer, String>>[] emptyArray = MutablePair.emptyArray();
    assertNotNull(emptyArray);
    assertEquals(0, emptyArray.length);
  }
}