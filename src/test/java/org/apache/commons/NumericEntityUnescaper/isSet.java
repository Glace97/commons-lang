import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class isSetTest {
    private NumericEntityUnescaper unescaper;

    @BeforeEach
    void setUp() {
        unescaper = new NumericEntityUnescaper();
    }

    @Test
    void testIsSetWithSemiColonRequired() {
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonRequired));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonOptional));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.errorIfNoSemiColon));
    }

    @Test
    void testIsSetWithSemiColonOptional() {
        unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional);
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonRequired));
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonOptional));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.errorIfNoSemiColon));
    }

    @Test
    void testIsSetWithErrorIfNoSemiColon() {
        unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon);
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonRequired));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonOptional));
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.errorIfNoSemiColon));
    }

    @Test
    void testIsSetWithMultipleOptions() {
        unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonRequired, NumericEntityUnescaper.OPTION.semiColonOptional);
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonRequired));
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonOptional));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.errorIfNoSemiColon));
    }
}