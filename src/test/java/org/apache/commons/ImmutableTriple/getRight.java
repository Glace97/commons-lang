import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getRightTest {
    
    private ImmutableTriple<String, Integer, Double> triple;
    
    @BeforeEach
    void setUp() {
        triple = new ImmutableTriple<>("left", 1, 1.0);
    }
    
    @Nested
    @DisplayName("Tests for getRight method")
    class GetRightTests {
        
        @Test
        @DisplayName("Return the right value when it is not null")
        void testGetRightNotNull() {
            String expected = "right";
            ImmutableTriple<String, Integer, Double> triple = new ImmutableTriple<>("left", 1, expected);
            
            String actual = triple.getRight();
            
            assertEquals(expected, actual);
        }
        
        @Test
        @DisplayName("Return null when the right value is null")
        void testGetRightNull() {
            ImmutableTriple<String, Integer, Double> triple = new ImmutableTriple<>("left", 1, null);
            
            String actual = triple.getRight();
            
            assertNull(actual);
        }
        
    }
    
}