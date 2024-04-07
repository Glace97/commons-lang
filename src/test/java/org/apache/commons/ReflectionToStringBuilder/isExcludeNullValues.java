import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class isExcludeNullValuesTest {
    
    private ReflectionToStringBuilder builder;
    
    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
    }
    
    @Test
    void testIsExcludeNullValues_True() {
        builder.excludeNullValues = true;
        assertTrue(builder.isExcludeNullValues());
    }
    
    @Test
    void testIsExcludeNullValues_False() {
        builder.excludeNullValues = false;
        assertFalse(builder.isExcludeNullValues());
    }
    
    @Test
    void testIsExcludeNullValues_DefaultValue() {
        assertFalse(builder.isExcludeNullValues());
    }
}