import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class isAnyBlankTest {

   @Test
   @DisplayName("Empty input should return false")
   void testIsAnyBlank_emptyInput() {
      assertFalse(StringUtils.isAnyBlank());
   }

   @Test
   @DisplayName("Null input should return false")
   void testIsAnyBlank_nullInput() {
      assertFalse(StringUtils.isAnyBlank((CharSequence[]) null));
   }

   @Test
   @DisplayName("Whitespace input should return true")
   void testIsAnyBlank_whitespaceInput() {
      assertTrue(StringUtils.isAnyBlank("  "));
   }

   @Test
   @DisplayName("Single non-blank input should return false")
   void testIsAnyBlank_singleNonBlankInput() {
      assertFalse(StringUtils.isAnyBlank("foo"));
   }

   @Test
   @DisplayName("Single blank input should return true")
   void testIsAnyBlank_singleBlankInput() {
      assertTrue(StringUtils.isAnyBlank(""));
   }

   @Test
   @DisplayName("Multiple non-blank inputs should return false")
   void testIsAnyBlank_multipleNonBlankInputs() {
      assertFalse(StringUtils.isAnyBlank("foo", "bar", "baz"));
   }

   @Test
   @DisplayName("Multiple blank inputs should return true")
   void testIsAnyBlank_multipleBlankInputs() {
      assertTrue(StringUtils.isAnyBlank("", " ", "\t"));
   }
}