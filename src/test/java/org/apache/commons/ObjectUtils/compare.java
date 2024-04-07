
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompareTest {
    
    @Nested
    @DisplayName("When comparing two Comparable objects")
    class ComparableComparison {
        
        @Test
        @DisplayName("Should return 0 when both objects are null")
        void shouldReturnZeroWhenBothObjectsAreNull() {
            Comparable<Object> c1 = null;
            Comparable<Object> c2 = null;
            
            int result = ObjectUtils.compare(c1, c2);
            
            assertEquals(0, result);
        }
        
        @Test
        @DisplayName("Should return a negative value when c1 is less than c2")
        void shouldReturnNegativeValueWhenC1IsLessThanC2() {
            Comparable<Integer> c1 = 5;
            Comparable<Integer> c2 = 10;
            
            int result = ObjectUtils.compare(c1, c2);
            
            assertTrue(result < 0);
        }
        
        @Test
        @DisplayName("Should return a positive value when c1 is greater than c2")
        void shouldReturnPositiveValueWhenC1IsGreaterThanC2() {
            Comparable<Integer> c1 = 10;
            Comparable<Integer> c2 = 5;
            
            int result = ObjectUtils.compare(c1, c2);
            
            assertTrue(result > 0);
        }
        
        @Test
        @DisplayName("Should return 0 when c1 is equal to c2")
        void shouldReturnZeroWhenC1IsEqualToC2() {
            Comparable<Integer> c1 = 10;
            Comparable<Integer> c2 = 10;
            
            int result = ObjectUtils.compare(c1, c2);
            
            assertEquals(0, result);
        }
    }
    
    @Nested
    @DisplayName("When comparing two Comparable objects with nullGreater=true")
    class ComparableComparisonWithNullGreater {
        
        @Test
        @DisplayName("Should return a positive value when c1 is null and c2 is not null")
        void shouldReturnPositiveValueWhenC1IsNullAndC2IsNotNull() {
            Comparable<Integer> c1 = null;
            Comparable<Integer> c2 = 5;
            
            int result = ObjectUtils.compare(c1, c2, true);
            
            assertTrue(result > 0);
        }
        
        @Test
        @DisplayName("Should return a negative value when c2 is null and c1 is not null")
        void shouldReturnNegativeValueWhenC2IsNullAndC1IsNotNull() {
            Comparable<Integer> c1 = 5;
            Comparable<Integer> c2 = null;
            
            int result = ObjectUtils.compare(c1, c2, true);
            
            assertTrue(result < 0);
        }
        
        @Test
        @DisplayName("Should return 0 when both c1 and c2 are null")
        void shouldReturnZeroWhenBothC1AndC2AreNull() {
            Comparable<Integer> c1 = null;
            Comparable<Integer> c2 = null;
            
            int result = ObjectUtils.compare(c1, c2, true);
            
            assertEquals(0, result);
        }
    }
}
