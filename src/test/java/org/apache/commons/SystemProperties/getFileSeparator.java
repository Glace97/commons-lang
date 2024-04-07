import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getFileSeparatorTest {
    @Test
    void testGetFileSeparator() {
        // Test when the file separator property exists
        Assertions.assertNotNull(System.getProperty("file.separator"));
        
        // Test when the file separator property is null
        Assertions.assertNull(System.getProperty(null));
        
        // Test when the file separator property is empty
        Assertions.assertEquals("", System.getProperty(""));
        
        // Test when the file separator property is not set
        Assertions.assertNull(System.getProperty("nonexistent.property"));
    }
}