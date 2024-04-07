import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getUserLanguageTest {

    @Test
    void testGetUserLanguage() {
        SystemProperties systemProperties = new SystemProperties();
        
        // Test when user.language property is set
        System.setProperty("user.language", "en");
        assertEquals("en", systemProperties.getUserLanguage());
        
        // Test when user.language property is not set
        System.clearProperty("user.language");
        assertEquals(null, systemProperties.getUserLanguage());
    }
    
}