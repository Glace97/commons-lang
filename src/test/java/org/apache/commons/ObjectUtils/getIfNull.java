import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ObjectUtilsTest {

    private ObjectUtils objectUtils;

    @BeforeEach
    void setUp() {
        objectUtils = new ObjectUtils();
    }

    @Nested
    @DisplayName("Tests for getIfNull method")
    class GetIfNullTest {

        @Test
        @DisplayName("Should return object if it is not null")
        void shouldReturnObjectIfNotNull() {
            // Arrange
            String object = "Sample Object";
            Supplier<String> defaultSupplier = mock(Supplier.class);

            // Act
            String result = objectUtils.getIfNull(object, defaultSupplier);

            // Assert
            assertEquals(object, result);
        }

        @Test
        @DisplayName("Should return default value if object is null")
        void shouldReturnDefaultValueIfNull() {
            // Arrange
            String object = null;
            Supplier<String> defaultSupplier = mock(Supplier.class);
            String defaultValue = "Default Value";
            when(defaultSupplier.get()).thenReturn(defaultValue);

            // Act
            String result = objectUtils.getIfNull(object, defaultSupplier);

            // Assert
            assertEquals(defaultValue, result);
        }

        @Test
        @DisplayName("Should return null if object is null and default supplier is null")
        void shouldReturnNullIfNullAndDefaultSupplierIsNull() {
            // Arrange
            String object = null;
            Supplier<String> defaultSupplier = null;

            // Act
            String result = objectUtils.getIfNull(object, defaultSupplier);

            // Assert
            assertNull(result);
        }
    }
}