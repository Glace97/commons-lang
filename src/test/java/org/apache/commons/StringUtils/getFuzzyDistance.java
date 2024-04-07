
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Locale;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getFuzzyDistanceTest {

    @Test
    void testNullInputs() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                StringUtils.getFuzzyDistance(null, null, Locale.ENGLISH));
    }

    @Test
    void testEmptyInputs() {
        int distance = StringUtils.getFuzzyDistance("", "", Locale.ENGLISH);
        Assertions.assertEquals(0, distance);
    }

    @Test
    void testSingleCharacterQuery() {
        int distance = StringUtils.getFuzzyDistance("Workshop", "b", Locale.ENGLISH);
        Assertions.assertEquals(0, distance);
    }

    @Test
    void testSingleCharacterMatch() {
        int distance = StringUtils.getFuzzyDistance("Room", "o", Locale.ENGLISH);
        Assertions.assertEquals(1, distance);
    }

    @Test
    void testSingleCharacterCaseInsensitiveMatch() {
        int distance = StringUtils.getFuzzyDistance("Workshop", "w", Locale.ENGLISH);
        Assertions.assertEquals(1, distance);
    }

    @Test
    void testMultipleCharacterMatch() {
        int distance = StringUtils.getFuzzyDistance("Workshop", "ws", Locale.ENGLISH);
        Assertions.assertEquals(2, distance);
    }

    @Test
    void testMultipleCharacterCaseInsensitiveMatch() {
        int distance = StringUtils.getFuzzyDistance("Workshop", "wo", Locale.ENGLISH);
        Assertions.assertEquals(4, distance);
    }

    @Test
    void testLongStringMatch() {
        int distance = StringUtils.getFuzzyDistance("Apache Software Foundation", "asf", Locale.ENGLISH);
        Assertions.assertEquals(3, distance);
    }
}
