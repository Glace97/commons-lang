import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class RemoveTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("remove(char remove) method")
    @TestInstance(Lifecycle.PER_CLASS)
    class RemoveCharTest {

        @Test
        @DisplayName("should return null when input string is null")
        void testRemoveChar_NullInput() {
            // Arrange
            String str = null;
            char remove = 'a';

            // Act
            String result = stringUtils.remove(str, remove);

            // Assert
            assertNull(result);
        }

        @Test
        @DisplayName("should return empty string when input string is empty")
        void testRemoveChar_EmptyInput() {
            // Arrange
            String str = "";
            char remove = 'a';

            // Act
            String result = stringUtils.remove(str, remove);

            // Assert
            assertEquals("", result);
        }

        @Test
        @DisplayName("should return input string unchanged when remove character is not present")
        void testRemoveChar_NoMatch() {
            // Arrange
            String str = "queued";
            char remove = 'z';

            // Act
            String result = stringUtils.remove(str, remove);

            // Assert
            assertEquals(str, result);
        }

        @Test
        @DisplayName("should remove all occurrences of remove character")
        void testRemoveChar_RemoveAllOccurrences() {
            // Arrange
            String str = "queued";
            char remove = 'u';
            String expected = "qeed";

            // Act
            String result = stringUtils.remove(str, remove);

            // Assert
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("remove(String remove) method")
    @TestInstance(Lifecycle.PER_CLASS)
    class RemoveStringTest {

        @Test
        @DisplayName("should return null when input string is null")
        void testRemoveString_NullInput() {
            // Arrange
            String str = null;
            String remove = "ue";

            // Act
            String result = stringUtils.remove(str, remove);

            // Assert
            assertNull(result);
        }

        @Test
        @DisplayName("should return empty string when input string is empty")
        void testRemoveString_EmptyInput() {
            // Arrange
            String str = "";
            String remove = "ue";

            // Act
            String result = stringUtils.remove(str, remove);

            // Assert
            assertEquals("", result);
        }

        @Test
        @DisplayName("should return input string unchanged when remove string is null")
        void testRemoveString_RemoveNull() {
            // Arrange
            String str = "queued";
            String remove = null;

            // Act
            String result = stringUtils.remove(str, remove);

            // Assert
            assertEquals(str, result);
        }

        @Test
        @DisplayName("should return input string unchanged when remove string is empty")
        void testRemoveString_RemoveEmpty() {
            // Arrange
            String str = "queued";
            String remove = "";

            // Act
            String result = stringUtils.remove(str, remove);

            // Assert
            assertEquals(str, result);
        }

        @Test
        @DisplayName("should remove all occurrences of remove string")
        void testRemoveString_RemoveAllOccurrences() {
            // Arrange
            String str = "queued";
            String remove = "ue";
            String expected = "qd";

            // Act
            String result = stringUtils.remove(str, remove);

            // Assert
            assertEquals(expected, result);
        }
    }
}