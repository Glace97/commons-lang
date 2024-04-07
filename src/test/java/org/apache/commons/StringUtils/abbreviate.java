
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.stream.Stream;

class AbbreviateTest {

    @Test
    void testAbbreviate_NullInput_ReturnNull() {
        String result = StringUtils.abbreviate(null, 10);
        Assertions.assertNull(result);
    }

    @Test
    void testAbbreviate_EmptyInput_ReturnEmptyString() {
        String result = StringUtils.abbreviate("", 10);
        Assertions.assertEquals("", result);
    }

    @Test
    void testAbbreviate_InputShorterThanMaxWidth_ReturnSameString() {
        String result = StringUtils.abbreviate("abcdefg", 10);
        Assertions.assertEquals("abcdefg", result);
    }

    @Test
    void testAbbreviate_InputEqualToMaxWidth_ReturnSameString() {
        String result = StringUtils.abbreviate("abcdefghij", 10);
        Assertions.assertEquals("abcdefghij", result);
    }

    @Test
    void testAbbreviate_InputLongerThanMaxWidth_ReturnAbbreviatedString() {
        String result = StringUtils.abbreviate("abcdefghijklmno", 10);
        Assertions.assertEquals("abcde...", result);
    }

    @Test
    void testAbbreviate_MaxWidthLessThanFour_ThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.abbreviate("abcdefg", 3);
        });
    }

    @Test
    void testAbbreviateWithOffset_NullInput_ReturnNull() {
        String result = StringUtils.abbreviate(null, 0, 10);
        Assertions.assertNull(result);
    }

    @Test
    void testAbbreviateWithOffset_EmptyInput_ReturnEmptyString() {
        String result = StringUtils.abbreviate("", 0, 10);
        Assertions.assertEquals("", result);
    }

    @Test
    void testAbbreviateWithOffset_InputShorterThanMaxWidth_ReturnSameString() {
        String result = StringUtils.abbreviate("abcdefg", 1, 10);
        Assertions.assertEquals("abcdefg", result);
    }

    @Test
    void testAbbreviateWithOffset_InputEqualToMaxWidth_ReturnSameString() {
        String result = StringUtils.abbreviate("abcdefghij", 4, 10);
        Assertions.assertEquals("abcdefghij", result);
    }

    @Test
    void testAbbreviateWithOffset_InputLongerThanMaxWidth_ReturnAbbreviatedString() {
        String result = StringUtils.abbreviate("abcdefghijklmno", 5, 10);
        Assertions.assertEquals("...fghij...", result);
    }

    @Test
    void testAbbreviateWithOffset_OffsetGreaterThanStringLength_ReturnAbbreviatedStringStartingFromEnd() {
        String result = StringUtils.abbreviate("abcdefghijklmno", 20, 10);
        Assertions.assertEquals("...ijklmno", result);
    }

    @Test
    void testAbbreviateWithOffset_MaxWidthLessThanFour_ThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.abbreviate("abcdefg", 0, 3);
        });
    }

    @Test
    void testAbbreviateWithAbbrevMarker_NullInput_ReturnNull() {
        String result = StringUtils.abbreviate(null, "...", 10);
        Assertions.assertNull(result);
    }

    @Test
    void testAbbreviateWithAbbrevMarker_EmptyInput_ReturnEmptyString() {
        String result = StringUtils.abbreviate("", "...", 10);
        Assertions.assertEquals("", result);
    }

    @Test
    void testAbbreviateWithAbbrevMarker_InputShorterThanMaxWidth_ReturnSameString() {
        String result = StringUtils.abbreviate("abcdefg", "...", 10);
        Assertions.assertEquals("abcdefg", result);
    }

    @Test
    void testAbbreviateWithAbbrevMarker_InputEqualToMaxWidth_ReturnSameString() {
        String result = StringUtils.abbreviate("abcdefghij", "...", 10);
        Assertions.assertEquals("abcdefghij", result);
    }

    @Test
    void testAbbreviateWithAbbrevMarker_InputLongerThanMaxWidth_ReturnAbbreviatedString() {
        String result = StringUtils.abbreviate("abcdefghijklmno", "...", 10);
        Assertions.assertEquals("abcdefghi...", result);
    }

    @Test
    void testAbbreviateWithAbbrevMarker_MaxWidthLessThanAbbrevMarkerLengthPlusOne_ThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.abbreviate("abcdefg", "...", 2);
        });
    }

    @Test
    void testAbbreviateWithAbbrevMarkerAndOffset_NullInput_ReturnNull() {
        String result = StringUtils.abbreviate(null, "...", 0, 10);
        Assertions.assertNull(result);
    }

    @Test
    void testAbbreviateWithAbbrevMarkerAndOffset_EmptyInput_ReturnEmptyString() {
        String result = StringUtils.abbreviate("", "...", 0, 10);
        Assertions.assertEquals("", result);
    }

    @Test
    void testAbbreviateWithAbbrevMarkerAndOffset_InputShorterThanMaxWidth_ReturnSameString() {
        String result = StringUtils.abbreviate("abcdefg", "...", 1, 10);
        Assertions.assertEquals("abcdefg", result);
    }

    @Test
    void testAbbreviateWithAbbrevMarkerAndOffset_InputEqualToMaxWidth_ReturnSameString() {
        String result = StringUtils.abbreviate("abcdefghij", "...", 4, 10);
        Assertions.assertEquals("abcdefghij", result);
    }

    @Test
    void testAbbreviateWithAbbrevMarkerAndOffset_InputLongerThanMaxWidth_ReturnAbbreviatedString() {
        String result = StringUtils.abbreviate("abcdefghijklmno", "...", 5, 10);
        Assertions.assertEquals("...fghij...", result);
    }

    @Test
    void testAbbreviateWithAbbrevMarkerAndOffset_OffsetGreaterThanStringLength_ReturnAbbreviatedStringStartingFromEnd() {
        String result = StringUtils.abbreviate("abcdefghijklmno", 20, 10);
        Assertions.assertEquals("...ijklmno", result);
    }

    @Test
    void testAbbreviateWithAbbrevMarkerAndOffset_MaxWidthLessThanAbbrevMarkerLengthPlusOne_ThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.abbreviate("abcdefg", "...", 0, 2);
        });
    }
}
