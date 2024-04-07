import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.Predicate;

class leTest {
  
  private ComparableUtils comparableUtils;
  
  @BeforeEach
  void setUp() {
    comparableUtils = new ComparableUtils();
  }
  
  @Test
  void testLeWhenObjectIsLessThanB() {
    Predicate<Integer> lePredicate = ComparableUtils.le(5);
    
    assertTrue(lePredicate.test(4));
    assertTrue(lePredicate.test(-10));
    assertFalse(lePredicate.test(10));
  }
  
  @Test
  void testLeWhenObjectIsEqualToB() {
    Predicate<Integer> lePredicate = ComparableUtils.le(5);
    
    assertTrue(lePredicate.test(5));
  }
  
  @Test
  void testLeWhenObjectIsGreaterThanB() {
    Predicate<Integer> lePredicate = ComparableUtils.le(5);
    
    assertFalse(lePredicate.test(6));
    assertFalse(lePredicate.test(10));
  }
  
  @Test
  void testLeWhenObjectIsLessThanBForDouble() {
    Predicate<Double> lePredicate = ComparableUtils.le(5.0);
    
    assertTrue(lePredicate.test(4.5));
    assertTrue(lePredicate.test(-10.0));
    assertFalse(lePredicate.test(10.0));
  }
  
  @Test
  void testLeWhenObjectIsEqualToBForDouble() {
    Predicate<Double> lePredicate = ComparableUtils.le(5.0);
    
    assertTrue(lePredicate.test(5.0));
  }
  
  @Test
  void testLeWhenObjectIsGreaterThanBForDouble() {
    Predicate<Double> lePredicate = ComparableUtils.le(5.0);
    
    assertFalse(lePredicate.test(6.0));
    assertFalse(lePredicate.test(10.0));
  }
  
  @Test
  void testLeWhenObjectIsLessThanBForString() {
    Predicate<String> lePredicate = ComparableUtils.le("apple");
    
    assertTrue(lePredicate.test("ant"));
    assertTrue(lePredicate.test("aardvark"));
    assertFalse(lePredicate.test("zebra"));
  }
  
  @Test
  void testLeWhenObjectIsEqualToBForString() {
    Predicate<String> lePredicate = ComparableUtils.le("apple");
    
    assertTrue(lePredicate.test("apple"));
  }
  
  @Test
  void testLeWhenObjectIsGreaterThanBForString() {
    Predicate<String> lePredicate = ComparableUtils.le("apple");
    
    assertFalse(lePredicate.test("banana"));
    assertFalse(lePredicate.test("zebra"));
  }
  
}