import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class parseObjectTest {
    
    @Test
    void testValidInput() {
        CompositeFormat format = new CompositeFormat(new CustomParser(), new CustomFormatter());
        String source = "123";
        ParsePosition pos = new ParsePosition(0);
        Object result = format.parseObject(source, pos);
        assertNotNull(result);
        assertEquals(123, result);
        assertEquals(source.length(), pos.getIndex());
    }
    
    @Test
    void testInvalidInput() {
        CompositeFormat format = new CompositeFormat(new CustomParser(), new CustomFormatter());
        String source = "abc";
        ParsePosition pos = new ParsePosition(0);
        Object result = format.parseObject(source, pos);
        assertNull(result);
        assertEquals(-1, pos.getErrorIndex());
    }
    
    @Test
    void testEmptyString() {
        CompositeFormat format = new CompositeFormat(new CustomParser(), new CustomFormatter());
        String source = "";
        ParsePosition pos = new ParsePosition(0);
        Object result = format.parseObject(source, pos);
        assertNull(result);
        assertEquals(0, pos.getIndex());
    }
    
    @Test
    void testNullSource() {
        CompositeFormat format = new CompositeFormat(new CustomParser(), new CustomFormatter());
        String source = null;
        ParsePosition pos = new ParsePosition(0);
        Object result = format.parseObject(source, pos);
        assertNull(result);
        assertEquals(0, pos.getIndex());
    }
    
    @Test
    void testInvalidPosition() {
        CompositeFormat format = new CompositeFormat(new CustomParser(), new CustomFormatter());
        String source = "123";
        ParsePosition pos = new ParsePosition(2);
        Object result = format.parseObject(source, pos);
        assertNull(result);
        assertEquals(2, pos.getErrorIndex());
    }
    
    @Test
    void testParserReturnsNull() {
        CompositeFormat format = new CompositeFormat(new NullParser(), new CustomFormatter());
        String source = "123";
        ParsePosition pos = new ParsePosition(0);
        Object result = format.parseObject(source, pos);
        assertNull(result);
        assertEquals(0, pos.getErrorIndex());
    }
    
    @Test
    void testFormatterReturnsNull() {
        CompositeFormat format = new CompositeFormat(new CustomParser(), new NullFormatter());
        String source = "123";
        ParsePosition pos = new ParsePosition(0);
        Object result = format.parseObject(source, pos);
        assertNull(result);
        assertEquals(0, pos.getErrorIndex());
    }
    
    @Test
    void testParserThrowsException() {
        CompositeFormat format = new CompositeFormat(new ExceptionParser(), new CustomFormatter());
        String source = "123";
        ParsePosition pos = new ParsePosition(0);
        assertThrows(ParseException.class, () -> {
            format.parseObject(source, pos);
        });
        assertEquals(0, pos.getIndex());
    }
    
    @Test
    void testFormatterThrowsException() {
        CompositeFormat format = new CompositeFormat(new CustomParser(), new ExceptionFormatter());
        String source = "123";
        ParsePosition pos = new ParsePosition(0);
        assertThrows(ParseException.class, () -> {
            format.parseObject(source, pos);
        });
        assertEquals(0, pos.getErrorIndex());
    }
    
    @Test
    void testBothParserAndFormatterThrowException() {
        CompositeFormat format = new CompositeFormat(new ExceptionParser(), new ExceptionFormatter());
        String source = "123";
        ParsePosition pos = new ParsePosition(0);
        assertThrows(ParseException.class, () -> {
            format.parseObject(source, pos);
        });
        assertEquals(0, pos.getIndex());
        assertEquals(0, pos.getErrorIndex());
    }
}

class CustomParser extends Format {
    @Override
    public Object parseObject(String source, ParsePosition pos) {
        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            pos.setErrorIndex(0);
            return null;
        }
    }
}

class CustomFormatter extends Format {
    @Override
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        return toAppendTo.append(obj.toString());
    }
}

class NullParser extends Format {
    @Override
    public Object parseObject(String source, ParsePosition pos) {
        return null;
    }
}

class NullFormatter extends Format {
    @Override
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        return null;
    }
}

class ExceptionParser extends Format {
    @Override
    public Object parseObject(String source, ParsePosition pos) throws ParseException {
        throw new ParseException("Error parsing object", 0);
    }
}

class ExceptionFormatter extends Format {
    @Override
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) throws ParseException {
        throw new ParseException("Error formatting object", 0);
    }
}