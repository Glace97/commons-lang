import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.security.AccessControlException;
import java.util.Properties;
import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

class SystemPropertiesTest {
    private SystemProperties systemProperties;

    @BeforeEach
    void setUp() {
        systemProperties = new SystemProperties();
    }

    @Nested
    @DisplayName("getJavaAwtFonts method")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class GetJavaAwtFontsTest {
        @Test
        @DisplayName("should return the value from the system properties map")
        void shouldReturnValueFromSystemProperties() {
            // Arrange
            String expectedValue = "Arial,Times New Roman";
            System.setProperty("java.awt.fonts", expectedValue);

            // Act
            String result = SystemProperties.getJavaAwtFonts();

            // Assert
            assertEquals(expectedValue, result);
        }

        @Test
        @DisplayName("should return null if the property cannot be read due to a SecurityException")
        void shouldReturnNullIfSecurityExceptionOccurs() {
            // Arrange
            mockSecurityException();

            // Act
            String result = SystemProperties.getJavaAwtFonts();

            // Assert
            assertEquals(null, result);
        }

        private void mockSecurityException() {
            Supplier<Properties> propertiesSupplier = mock(Supplier.class);
            when(propertiesSupplier.get()).thenThrow(AccessControlException.class);
            Suppliers.setOverride(propertiesSupplier);
        }
    }
}