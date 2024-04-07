import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class getUserCountryTest {

    @Test
    void testGetUserCountry() {
        // Test case 1: User country is set to "US"
        System.setProperty("user.country", "US");
        assertEquals("US", SystemProperties.getUserCountry());
        
        // Test case 2: User country is set to "GB"
        System.setProperty("user.country", "GB");
        assertEquals("GB", SystemProperties.getUserCountry());
        
        // Test case 3: User country is set to "DE"
        System.setProperty("user.country", "DE");
        assertEquals("DE", SystemProperties.getUserCountry());
        
        // Test case 4: User country is set to null
        System.clearProperty("user.country");
        assertEquals(null, SystemProperties.getUserCountry());
        
        // Test case 5: User country is not set
        assertEquals(null, SystemProperties.getUserCountry());
    }
}