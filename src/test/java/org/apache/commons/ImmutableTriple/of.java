import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ofTest {

    @Nested
    @DisplayName("Test for of method")
    class OfMethodTests {
        
        @Test
        @DisplayName("Test for non-null parameters")
        void testNonNullParameters() {
            // Arrange
            Object left = new Object();
            Object middle = new Object();
            Object right = new Object();
            
            // Act
            ImmutableTriple<Object, Object, Object> triple = ImmutableTriple.of(left, middle, right);
            
            // Assert
            assertNotNull(triple);
            assertEquals(left, triple.left);
            assertEquals(middle, triple.middle);
            assertEquals(right, triple.right);
        }
        
        @Test
        @DisplayName("Test for null parameters")
        void testNullParameters() {
            // Arrange
            
            // Act
            ImmutableTriple<Object, Object, Object> triple = ImmutableTriple.of(null, null, null);
            
            // Assert
            assertNotNull(triple);
            assertNull(triple.left);
            assertNull(triple.middle);
            assertNull(triple.right);
        }
        
        @ParameterizedTest
        @ValueSource(objects = {null, "", " ", "\t", "\n"})
        @DisplayName("Test for empty or whitespace parameters")
        void testEmptyOrWhitespaceParameters(Object parameter) {
            // Arrange
            
            // Act
            ImmutableTriple<Object, Object, Object> triple = ImmutableTriple.of(parameter, parameter, parameter);
            
            // Assert
            assertNotNull(triple);
            assertEquals(parameter, triple.left);
            assertEquals(parameter, triple.middle);
            assertEquals(parameter, triple.right);
        }
        
        @Test
        @DisplayName("Test for nullTriple")
        void testNullTriple() {
            // Arrange
            
            // Act
            ImmutableTriple<Object, Object, Object> triple = ImmutableTriple.nullTriple();
            
            // Assert
            assertNotNull(triple);
            assertNull(triple.left);
            assertNull(triple.middle);
            assertNull(triple.right);
        }
    }
}