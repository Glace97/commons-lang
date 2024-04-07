
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("equals method tests")
class equalsTest {
    FluentBitSet bitSet1;
    FluentBitSet bitSet2;
    FluentBitSet bitSet3;

    @BeforeEach
    void setUp() {
        BitSet set1 = new BitSet();
        BitSet set2 = new BitSet();
        BitSet set3 = new BitSet();
        set1.set(0);
        set2.set(0);
        set3.set(1);
        bitSet1 = new FluentBitSet(set1);
        bitSet2 = new FluentBitSet(set2);
        bitSet3 = new FluentBitSet(set3);
    }

    @Nested
    @DisplayName("when comparing with itself")
    class WhenComparingWithItself {
        @Test
        @DisplayName("should return true")
        void shouldReturnTrue() {
            assertTrue(bitSet1.equals(bitSet1));
        }
    }

    @Nested
    @DisplayName("when comparing with null")
    class WhenComparingWithNull {
        @Test
        @DisplayName("should return false")
        void shouldReturnFalse() {
            assertFalse(bitSet1.equals(null));
        }
    }

    @Nested
    @DisplayName("when comparing with an object of a different class")
    class WhenComparingWithDifferentClass {
        @Test
        @DisplayName("should return false")
        void shouldReturnFalse() {
            assertFalse(bitSet1.equals("test"));
        }
    }

    @Nested
    @DisplayName("when comparing with an equal FluentBitSet")
    class WhenComparingWithEqualFluentBitSet {
        @Test
        @DisplayName("should return true")
        void shouldReturnTrue() {
            assertTrue(bitSet1.equals(bitSet2));
        }
    }

    @Nested
    @DisplayName("when comparing with a FluentBitSet with a different BitSet")
    class WhenComparingWithFluentBitSetWithDifferentBitSet {
        @Test
        @DisplayName("should return false")
        void shouldReturnFalse() {
            assertFalse(bitSet1.equals(bitSet3));
        }
    }
}
