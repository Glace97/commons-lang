
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getUserTimezoneTest {

    @Test
    void testUserTimezone() {
        SystemProperties systemProperties = new SystemProperties();
        String expectedTimezone = System.getProperty("user.timezone");

        String actualTimezone = systemProperties.getUserTimezone();

        assertEquals(expectedTimezone, actualTimezone);
    }

    @Test
    void testNullUserTimezone() {
        SystemProperties systemProperties = new SystemProperties();
        String expectedTimezone = null;

        // Set user.timezone property to null
        System.setProperty("user.timezone", null);

        String actualTimezone = systemProperties.getUserTimezone();

        assertEquals(expectedTimezone, actualTimezone);
    }

    @Test
    void testSecurityException() {
        SystemProperties systemProperties = new SystemProperties();
        String expectedTimezone = null;

        // Mock SecurityException by throwing it
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPropertyAccess(String key) {
                throw new SecurityException();
            }
        });

        String actualTimezone = systemProperties.getUserTimezone();

        assertEquals(expectedTimezone, actualTimezone);
    }
}
