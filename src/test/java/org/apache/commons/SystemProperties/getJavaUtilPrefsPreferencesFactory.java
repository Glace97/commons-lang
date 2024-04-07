import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class getJavaUtilPrefsPreferencesFactoryTest {

    private SystemProperties systemProperties;

    @BeforeEach
    void setUp() {
        systemProperties = new SystemProperties();
    }

    @Test
    void testGetJavaUtilPrefsPreferencesFactory() {
        String expected = "java.util.prefs.PreferencesFactory";
        String actual = systemProperties.getJavaUtilPrefsPreferencesFactory();
        assertEquals(expected, actual);
    }

    @Test
    void testGetJavaUtilPrefsPreferencesFactory_Null() {
        String actual = systemProperties.getJavaUtilPrefsPreferencesFactory();
        assertNull(actual);
    }
}