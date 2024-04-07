import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getRawOffsetTest {
    
    @Test
    void testPositiveOffset() {
        GmtTimeZone timeZone = new GmtTimeZone(false, 2, 30);
        Assertions.assertEquals(150 * 60 * 1000, timeZone.getRawOffset());
    }
    
    @Test
    void testNegativeOffset() {
        GmtTimeZone timeZone = new GmtTimeZone(true, 1, 45);
        Assertions.assertEquals(-105 * 60 * 1000, timeZone.getRawOffset());
    }
    
    @Test
    void testZeroOffset() {
        GmtTimeZone timeZone = new GmtTimeZone(false, 0, 0);
        Assertions.assertEquals(0, timeZone.getRawOffset());
    }
    
    @Test
    void testOutOfRangeHours() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GmtTimeZone timeZone = new GmtTimeZone(false, 25, 0);
        });
    }
    
    @Test
    void testOutOfRangeMinutes() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GmtTimeZone timeZone = new GmtTimeZone(false, 2, 75);
        });
    }
}