import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hashCodeTest {
    private ExtendedMessageFormat format1;
    private ExtendedMessageFormat format2;

    @BeforeEach
    void setUp() {
        format1 = new ExtendedMessageFormat("Pattern 1");
        format2 = new ExtendedMessageFormat("Pattern 2");
    }

    @Test
    void testHashCodeEqualObjects() {
        assertEquals(format1.hashCode(), format1.hashCode());
    }

    @Test
    void testHashCodeSamePattern() {
        ExtendedMessageFormat format3 = new ExtendedMessageFormat("Pattern 1");
        assertEquals(format1.hashCode(), format3.hashCode());
    }

    @Test
    void testHashCodeDifferentPattern() {
        assertNotEquals(format1.hashCode(), format2.hashCode());
    }

    @Test
    void testHashCodeNullPattern() {
        ExtendedMessageFormat format4 = new ExtendedMessageFormat(null);
        assertNotEquals(format1.hashCode(), format4.hashCode());
    }

    @Test
    void testHashCodeNullRegistry() {
        ExtendedMessageFormat format5 = new ExtendedMessageFormat("Pattern", null);
        assertNotEquals(format1.hashCode(), format5.hashCode());
    }
}