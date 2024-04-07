import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class twoDigitsTest {

    @Test
    void testTwoDigitsWithSingleDigit() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, 5);
        assertEquals("05", sb.toString());
    }
    
    @Test
    void testTwoDigitsWithDoubleDigit() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, 12);
        assertEquals("12", sb.toString());
    }
    
    @Test
    void testTwoDigitsWithZero() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, 0);
        assertEquals("00", sb.toString());
    }
    
    @Test
    void testTwoDigitsWithNegativeNumber() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, -5);
        assertEquals("-05", sb.toString());
    }
    
    @Test
    void testTwoDigitsWithLargeNumber() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, 999);
        assertEquals("99", sb.toString());
    }
    
    @Test
    void testTwoDigitsWithNegativeLargeNumber() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, -999);
        assertEquals("-99", sb.toString());
    }
    
    @Test
    void testTwoDigitsWithMaxValue() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, Integer.MAX_VALUE);
        assertEquals("21", sb.toString());
    }
    
    @Test
    void testTwoDigitsWithMinValue() {
        StringBuilder sb = new StringBuilder();
        GmtTimeZone.twoDigits(sb, Integer.MIN_VALUE);
        assertEquals("-21", sb.toString());
    }
}