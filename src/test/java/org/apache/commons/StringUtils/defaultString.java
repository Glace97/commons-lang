import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class defaultStringTest {
    
    private StringUtils stringUtils;
    
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }
    
    @Test
    @DisplayName("Test defaultString with null input")
    void testDefaultStringWithNullInput() {
        String result = stringUtils.defaultString(null);
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Test defaultString with empty input")
    void testDefaultStringWithEmptyInput() {
        String result = stringUtils.defaultString("");
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Test defaultString with non-null input")
    void testDefaultStringWithNonNullInput() {
        String result = stringUtils.defaultString("bat");
        assertEquals("bat", result);
    }
    
    @Test
    @DisplayName("Test defaultString with null input and nullDefault")
    void testDefaultStringWithNullInputAndNullDefault() {
        String result = stringUtils.defaultString(null, "NULL");
        assertEquals("NULL", result);
    }
    
    @Test
    @DisplayName("Test defaultString with empty input and nullDefault")
    void testDefaultStringWithEmptyInputAndNullDefault() {
        String result = stringUtils.defaultString("", "NULL");
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Test defaultString with non-null input and nullDefault")
    void testDefaultStringWithNonNullInputAndNullDefault() {
        String result = stringUtils.defaultString("bat", "NULL");
        assertEquals("bat", result);
    }
}