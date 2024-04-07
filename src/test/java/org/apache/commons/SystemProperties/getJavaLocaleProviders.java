
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getJavaLocaleProvidersTest {

    @Test
    void testGetJavaLocaleProviders() {
        String javaLocaleProviders = SystemProperties.getJavaLocaleProviders();
        assertNull(javaLocaleProviders);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "JRE",
            "CLDR SPI",
            "HOST",
            "JRE,CLDR SPI,HOST"
    })
    void testGetJavaLocaleProvidersWithValue(String value) {
        System.setProperty("java.locale.providers", value);
        String javaLocaleProviders = SystemProperties.getJavaLocaleProviders();
        assertEquals(value, javaLocaleProviders);
    }

    @Test
    void testGetJavaLocaleProvidersWithSecurityException() {
        System.setSecurityManager(new SecurityManager());
        String javaLocaleProviders = SystemProperties.getJavaLocaleProviders();
        assertNull(javaLocaleProviders);
    }

}
