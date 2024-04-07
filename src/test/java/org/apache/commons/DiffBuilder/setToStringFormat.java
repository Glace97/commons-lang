import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class setToStringFormatTest {
    
    @Test
    void testDefaultToStringFormat() {
        DiffBuilder<String> diffBuilder = new DiffBuilder<>();
        diffBuilder.setToStringFormat(null);
        assertEquals("%s differs from %s", diffBuilder.toStringFormat);
    }
    
    @Test
    void testCustomToStringFormat() {
        DiffBuilder<String> diffBuilder = new DiffBuilder<>();
        diffBuilder.setToStringFormat("Field %s is different from %s");
        assertEquals("Field %s is different from %s", diffBuilder.toStringFormat);
    }
    
    @Test
    void testSetToStringFormatWithNull() {
        DiffBuilder<String> diffBuilder = new DiffBuilder<>();
        diffBuilder.setToStringFormat(null);
        assertEquals("%s differs from %s", diffBuilder.toStringFormat);
    }
    
    @Test
    void testSetToStringFormatWithEmptyString() {
        DiffBuilder<String> diffBuilder = new DiffBuilder<>();
        diffBuilder.setToStringFormat("");
        assertEquals("", diffBuilder.toStringFormat);
    }
    
    @Test
    void testSetToStringFormatWithValidString() {
        DiffBuilder<String> diffBuilder = new DiffBuilder<>();
        diffBuilder.setToStringFormat("Field %s is different from %s");
        assertEquals("Field %s is different from %s", diffBuilder.toStringFormat);
    }
    
    @Test
    void testSetToStringFormatWithInvalidString() {
        DiffBuilder<String> diffBuilder = new DiffBuilder<>();
        diffBuilder.setToStringFormat("Invalid format string %");
        assertEquals("Invalid format string %", diffBuilder.toStringFormat);
    }
    
}