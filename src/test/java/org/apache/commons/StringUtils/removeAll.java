import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RemoveAllTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Tests for removeAll method")
    class RemoveAllTests {
        
        @Test
        @DisplayName("Test removing null from text")
        void testRemoveAllNull() {
            assertNull(stringUtils.removeAll(null, "abc"));
        }
        
        @Test
        @DisplayName("Test removing empty string from text")
        void testRemoveAllEmpty() {
            assertEquals("abc", stringUtils.removeAll("abc", ""));
        }
        
        @Test
        @DisplayName("Test removing regex .* from text")
        void testRemoveAllRegex1() {
            assertEquals("", stringUtils.removeAll("abc", ".*"));
        }
        
        @Test
        @DisplayName("Test removing regex .+ from text")
        void testRemoveAllRegex2() {
            assertEquals("", stringUtils.removeAll("abc", ".+"));
        }
        
        @Test
        @DisplayName("Test removing regex .? from text")
        void testRemoveAllRegex3() {
            assertEquals("", stringUtils.removeAll("abc", ".?"));
        }
        
        @Test
        @DisplayName("Test removing regex <.*> from text")
        void testRemoveAllRegex4() {
            assertEquals("A\nB", stringUtils.removeAll("A<__>\n<__>B", "<.*>"));
        }
        
        @Test
        @DisplayName("Test removing regex (?s)<.*> from text")
        void testRemoveAllRegex5() {
            assertEquals("AB", stringUtils.removeAll("A<__>\n<__>B", "(?s)<.*>"));
        }
        
        @Test
        @DisplayName("Test removing regex [a-z] from text")
        void testRemoveAllRegex6() {
            assertEquals("ABC123", stringUtils.removeAll("ABCabc123abc", "[a-z]"));
        }
    }
}