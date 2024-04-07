import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class setArrayEndTest {
    
    private StandardToStringStyle style;
    
    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }
    
    @Test
    void testSetArrayEndWithNonNullString() {
        String arrayEnd = "end";
        style.setArrayEnd(arrayEnd);
        assertEquals(arrayEnd, style.getArrayEnd());
    }
    
    @Test
    void testSetArrayEndWithNullString() {
        style.setArrayEnd(null);
        assertEquals("", style.getArrayEnd());
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n"})
    void testSetArrayEndWithEmptyString(String arrayEnd) {
        style.setArrayEnd(arrayEnd);
        assertEquals("", style.getArrayEnd());
    }
    
    // Add more test cases for edge cases if needed
    
}