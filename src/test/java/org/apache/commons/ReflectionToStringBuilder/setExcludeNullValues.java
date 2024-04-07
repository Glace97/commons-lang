import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class setExcludeNullValuesTest {

    private ReflectionToStringBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
    }

    @Nested
    @DisplayName("When excludeNullValues is set to true")
    class WhenExcludeNullValuesIsTrue {

        @BeforeEach
        void setUp() {
            builder.setExcludeNullValues(true);
        }

        @Test
        @DisplayName("should exclude fields with null values")
        void shouldExcludeFieldsWithNullValues() {
            // Arrange
            Object object = new Object();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(object, null);
            }

            // Act
            String result = builder.toString();

            // Assert
            assertFalse(result.contains("null"));
        }

        @Test
        @DisplayName("should include fields with non-null values")
        void shouldIncludeFieldsWithNonNullValues() {
            // Arrange
            Object object = new Object();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(object, "value");
            }

            // Act
            String result = builder.toString();

            // Assert
            assertTrue(result.contains("value"));
        }
    }

    @Nested
    @DisplayName("When excludeNullValues is set to false")
    class WhenExcludeNullValuesIsFalse {

        @BeforeEach
        void setUp() {
            builder.setExcludeNullValues(false);
        }

        @Test
        @DisplayName("should include fields with null values")
        void shouldIncludeFieldsWithNullValues() {
            // Arrange
            Object object = new Object();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(object, null);
            }

            // Act
            String result = builder.toString();

            // Assert
            assertTrue(result.contains("null"));
        }

        @Test
        @DisplayName("should include fields with non-null values")
        void shouldIncludeFieldsWithNonNullValues() {
            // Arrange
            Object object = new Object();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(object, "value");
            }

            // Act
            String result = builder.toString();

            // Assert
            assertTrue(result.contains("value"));
        }
    }
}