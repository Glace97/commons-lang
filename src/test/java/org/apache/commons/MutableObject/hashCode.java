import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("hashCode() Test Suite")
class hashCodeTest {

    private MutableObject mutableObject;

    @BeforeEach
    void setUp() {
        mutableObject = new MutableObject();
    }

    @Nested
    @DisplayName("When value is null")
    class WhenValueIsNull {

        @BeforeEach
        void setUp() {
            mutableObject = new MutableObject(null);
        }

        @Test
        @DisplayName("Returns 0")
        void returnsZero() {
            assertEquals(0, mutableObject.hashCode());
        }
    }

    @Nested
    @DisplayName("When value is not null")
    class WhenValueIsNotNull {

        private final String value = "Test";

        @BeforeEach
        void setUp() {
            mutableObject = new MutableObject(value);
        }

        @Test
        @DisplayName("Returns the value's hash code")
        void returnsHashCode() {
            assertEquals(value.hashCode(), mutableObject.hashCode());
        }

        @Test
        @DisplayName("Does not return 0")
        void doesNotReturnZero() {
            assertNotEquals(0, mutableObject.hashCode());
        }

        @Test
        @DisplayName("Returns the same hash code for equal values")
        void returnsSameHashCodeForEqualValues() {
            MutableObject otherObject = new MutableObject(value);
            assertEquals(mutableObject.hashCode(), otherObject.hashCode());
        }

        @Test
        @DisplayName("Returns different hash codes for different values")
        void returnsDifferentHashCodesForDifferentValues() {
            MutableObject otherObject = new MutableObject("Different");
            assertNotEquals(mutableObject.hashCode(), otherObject.hashCode());
        }
    }
}