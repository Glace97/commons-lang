import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("inclusiveBetweenTest")
class inclusiveBetweenTest {

    @Nested
    @DisplayName("Tests for inclusiveBetween(double, double, double)")
    class DoubleTests {
        
        @Test
        @DisplayName("Valid values within range")
        void testInclusiveBetween_ValidValues() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0.1, 2.1, 1.1));
        }
        
        @Test
        @DisplayName("Value below range")
        void testInclusiveBetween_ValueBelowRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0.1, 2.1, 0.05));
        }
        
        @Test
        @DisplayName("Value above range")
        void testInclusiveBetween_ValueAboveRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0.1, 2.1, 2.15));
        }
        
        @Test
        @DisplayName("Value equal to start range")
        void testInclusiveBetween_ValueEqualToStartRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0.1, 2.1, 0.1));
        }
        
        @Test
        @DisplayName("Value equal to end range")
        void testInclusiveBetween_ValueEqualToEndRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0.1, 2.1, 2.1));
        }
    }

    @Nested
    @DisplayName("Tests for inclusiveBetween(double, double, double, String)")
    class DoubleWithMessageTests {
        
        @Test
        @DisplayName("Valid values within range")
        void testInclusiveBetweenWithMessage_ValidValues() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0.1, 2.1, 1.1, "Not in range"));
        }
        
        @Test
        @DisplayName("Value below range")
        void testInclusiveBetweenWithMessage_ValueBelowRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0.1, 2.1, 0.05, "Not in range"));
        }
        
        @Test
        @DisplayName("Value above range")
        void testInclusiveBetweenWithMessage_ValueAboveRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0.1, 2.1, 2.15, "Not in range"));
        }
        
        @Test
        @DisplayName("Value equal to start range")
        void testInclusiveBetweenWithMessage_ValueEqualToStartRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0.1, 2.1, 0.1, "Not in range"));
        }
        
        @Test
        @DisplayName("Value equal to end range")
        void testInclusiveBetweenWithMessage_ValueEqualToEndRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0.1, 2.1, 2.1, "Not in range"));
        }
    }

    @Nested
    @DisplayName("Tests for inclusiveBetween(long, long, long)")
    class LongTests {
        
        @Test
        @DisplayName("Valid values within range")
        void testInclusiveBetween_ValidValues() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 1));
        }
        
        @Test
        @DisplayName("Value below range")
        void testInclusiveBetween_ValueBelowRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, -1));
        }
        
        @Test
        @DisplayName("Value above range")
        void testInclusiveBetween_ValueAboveRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, 3));
        }
        
        @Test
        @DisplayName("Value equal to start range")
        void testInclusiveBetween_ValueEqualToStartRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 0));
        }
        
        @Test
        @DisplayName("Value equal to end range")
        void testInclusiveBetween_ValueEqualToEndRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 2));
        }
    }

    @Nested
    @DisplayName("Tests for inclusiveBetween(long, long, long, String)")
    class LongWithMessageTests {
        
        @Test
        @DisplayName("Valid values within range")
        void testInclusiveBetweenWithMessage_ValidValues() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 1, "Not in range"));
        }
        
        @Test
        @DisplayName("Value below range")
        void testInclusiveBetweenWithMessage_ValueBelowRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, -1, "Not in range"));
        }
        
        @Test
        @DisplayName("Value above range")
        void testInclusiveBetweenWithMessage_ValueAboveRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, 3, "Not in range"));
        }
        
        @Test
        @DisplayName("Value equal to start range")
        void testInclusiveBetweenWithMessage_ValueEqualToStartRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 0, "Not in range"));
        }
        
        @Test
        @DisplayName("Value equal to end range")
        void testInclusiveBetweenWithMessage_ValueEqualToEndRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 2, "Not in range"));
        }
    }

    @Nested
    @DisplayName("Tests for inclusiveBetween(T, T, Comparable)")
    class ComparableTests {
        
        @Test
        @DisplayName("Valid values within range")
        void testInclusiveBetween_ValidValues() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 1));
        }
        
        @Test
        @DisplayName("Value below range")
        void testInclusiveBetween_ValueBelowRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, -1));
        }
        
        @Test
        @DisplayName("Value above range")
        void testInclusiveBetween_ValueAboveRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, 3));
        }
        
        @Test
        @DisplayName("Value equal to start range")
        void testInclusiveBetween_ValueEqualToStartRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 0));
        }
        
        @Test
        @DisplayName("Value equal to end range")
        void testInclusiveBetween_ValueEqualToEndRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 2));
        }
    }

    @Nested
    @DisplayName("Tests for inclusiveBetween(T, T, Comparable, String, Object...)")
    class ComparableWithMessageTests {
        
        @Test
        @DisplayName("Valid values within range")
        void testInclusiveBetweenWithMessage_ValidValues() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 1, "Not in range"));
        }
        
        @Test
        @DisplayName("Value below range")
        void testInclusiveBetweenWithMessage_ValueBelowRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, -1, "Not in range"));
        }
        
        @Test
        @DisplayName("Value above range")
        void testInclusiveBetweenWithMessage_ValueAboveRange() {
            assertThrows(IllegalArgumentException.class, () -> Validate.inclusiveBetween(0, 2, 3, "Not in range"));
        }
        
        @Test
        @DisplayName("Value equal to start range")
        void testInclusiveBetweenWithMessage_ValueEqualToStartRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 0, "Not in range"));
        }
        
        @Test
        @DisplayName("Value equal to end range")
        void testInclusiveBetweenWithMessage_ValueEqualToEndRange() {
            assertDoesNotThrow(() -> Validate.inclusiveBetween(0, 2, 2, "Not in range"));
        }
    }

}