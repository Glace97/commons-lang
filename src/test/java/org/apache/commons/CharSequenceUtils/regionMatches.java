
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class regionMatchesTest {

    @Test
    void testRegionMatches() {
        CharSequenceUtils utils = new CharSequenceUtils();

        // Test case 1: Match case-sensitive region
        CharSequence cs1 = "Hello, World!";
        CharSequence substring1 = "Hello";
        boolean result1 = utils.regionMatches(cs1, false, 0, substring1, 0, 5);
        assertTrue(result1);

        // Test case 2: Match case-insensitive region
        CharSequence cs2 = "Hello, World!";
        CharSequence substring2 = "hello";
        boolean result2 = utils.regionMatches(cs2, true, 0, substring2, 0, 5);
        assertTrue(result2);

        // Test case 3: No match
        CharSequence cs3 = "Hello, World!";
        CharSequence substring3 = "Foo";
        boolean result3 = utils.regionMatches(cs3, false, 0, substring3, 0, 3);
        assertFalse(result3);

        // Test case 4: Invalid parameters - negative start index
        CharSequence cs4 = "Hello, World!";
        CharSequence substring4 = "Hello";
        boolean result4 = utils.regionMatches(cs4, false, -1, substring4, 0, 5);
        assertFalse(result4);

        // Test case 5: Invalid parameters - negative length
        CharSequence cs5 = "Hello, World!";
        CharSequence substring5 = "Hello";
        boolean result5 = utils.regionMatches(cs5, false, 0, substring5, 0, -5);
        assertFalse(result5);

        // Test case 6: Invalid parameters - region too long
        CharSequence cs6 = "Hello, World!";
        CharSequence substring6 = "Hello";
        boolean result6 = utils.regionMatches(cs6, false, 0, substring6, 0, 10);
        assertFalse(result6);

        // Test case 7: Match with CharSequence instances as input
        CharSequence cs7 = new StringBuilder("Hello, World!");
        CharSequence substring7 = new StringBuilder("Hello");
        boolean result7 = utils.regionMatches(cs7, false, 0, substring7, 0, 5);
        assertTrue(result7);
    }
}
