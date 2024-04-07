import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class geTest {

   @Test
   void testGe() {
      // Test when a is greater than b
      assertTrue(ComparableUtils.ge(5).test(10));
      assertTrue(ComparableUtils.ge(5).test(5));
      assertFalse(ComparableUtils.ge(5).test(2));
      
      // Test when a is less than b
      assertFalse(ComparableUtils.ge(10).test(5));
      assertFalse(ComparableUtils.ge(2).test(5));
      
      // Test when a is equal to b
      assertTrue(ComparableUtils.ge(5).test(5));
   }
   
}