import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class toStringTest {
    
    @Test
    void testToStringWithDefaultValue() {
        MutableShort mutableShort = new MutableShort();
        assertEquals("0", mutableShort.toString());
    }
    
    @Test
    void testToStringWithValue() {
        MutableShort mutableShort = new MutableShort((short) 10);
        assertEquals("10", mutableShort.toString());
    }
    
    @Test
    void testToStringWithNumberValue() {
        MutableShort mutableShort = new MutableShort(NumberUtils.createNumber("20"));
        assertEquals("20", mutableShort.toString());
    }
    
    @Test
    void testToStringWithStringValue() {
        MutableShort mutableShort = new MutableShort("30");
        assertEquals("30", mutableShort.toString());
    }
    
    @Test
    void testToStringWithNegativeValue() {
        MutableShort mutableShort = new MutableShort((short) -5);
        assertEquals("-5", mutableShort.toString());
    }
    
    @Test
    void testToStringWithMaxValue() {
        MutableShort mutableShort = new MutableShort(Short.MAX_VALUE);
        assertEquals("32767", mutableShort.toString());
    }
    
    @Test
    void testToStringWithMinValue() {
        MutableShort mutableShort = new MutableShort(Short.MIN_VALUE);
        assertEquals("-32768", mutableShort.toString());
    }
}