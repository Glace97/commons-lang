import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestSuite;

class toStringOnOffTest {

    @Test
    void testToStringOnOff_withTrue_shouldReturnOn() {
        assertEquals("on", BooleanUtils.toStringOnOff(true));
    }

    @Test
    void testToStringOnOff_withFalse_shouldReturnOff() {
        assertEquals("off", BooleanUtils.toStringOnOff(false));
    }

    @Test
    void testToStringOnOff_withNull_shouldReturnNull() {
        assertEquals(null, BooleanUtils.toStringOnOff((Boolean) null));
    }

    @Test
    void testToStringOnOff_withBooleanTrue_shouldReturnOn() {
        assertEquals("on", BooleanUtils.toStringOnOff(Boolean.TRUE));
    }

    @Test
    void testToStringOnOff_withBooleanFalse_shouldReturnOff() {
        assertEquals("off", BooleanUtils.toStringOnOff(Boolean.FALSE));
    }

    @Test
    void testToStringOnOff_withBooleanNull_shouldReturnNull() {
        assertEquals(null, BooleanUtils.toStringOnOff((Boolean) null));
    }

    @Test
    void testToStringOnOff_withInvalidBoolean_shouldReturnNull() {
        assertEquals(null, BooleanUtils.toStringOnOff("invalid"));
    }

    @Test
    void testToStringOnOff_withEmptyString_shouldReturnNull() {
        assertEquals(null, BooleanUtils.toStringOnOff(""));
    }

    @Test
    void testToStringOnOff_withNoString_shouldReturnOff() {
        assertEquals("off", BooleanUtils.toStringOnOff("no"));
    }

    @Test
    void testToStringOnOff_withYesString_shouldReturnOn() {
        assertEquals("on", BooleanUtils.toStringOnOff("yes"));
    }

    @Test
    void testToStringOnOff_withInvalidNumberString_shouldReturnNull() {
        assertEquals(null, BooleanUtils.toStringOnOff("123"));
    }

    @Test
    void testToStringOnOff_withNumberStringZero_shouldReturnOff() {
        assertEquals("off", BooleanUtils.toStringOnOff("0"));
    }

    @Test
    void testToStringOnOff_withNumberStringNonZero_shouldReturnOn() {
        assertEquals("on", BooleanUtils.toStringOnOff("1"));
    }
}

public class TestSuite {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new toStringOnOffTest());
        return suite;
    }
}