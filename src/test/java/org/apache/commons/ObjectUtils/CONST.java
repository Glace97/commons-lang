import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.stream.Streams;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.time.DurationUtils;

class CONSTTest {

    @Test
    void testCONSTBoolean() {
        boolean result = ObjectUtils.CONST(true);
        assertEquals(true, result);
        
        result = ObjectUtils.CONST(false);
        assertEquals(false, result);
    }
    
    @Test
    void testCONSTByte() {
        byte result = ObjectUtils.CONST((byte) 127);
        assertEquals((byte) 127, result);
        
        result = ObjectUtils.CONST((byte) -128);
        assertEquals((byte) -128, result);
    }
    
    @Test
    void testCONSTChar() {
        char result = ObjectUtils.CONST('a');
        assertEquals('a', result);
        
        result = ObjectUtils.CONST('@');
        assertEquals('@', result);
    }
    
    @Test
    void testCONSTDouble() {
        double result = ObjectUtils.CONST(1.0);
        assertEquals(1.0, result);
        
        result = ObjectUtils.CONST(0.0);
        assertEquals(0.0, result);
    }
    
    @Test
    void testCONSTFloat() {
        float result = ObjectUtils.CONST(1.0f);
        assertEquals(1.0f, result);
        
        result = ObjectUtils.CONST(0.0f);
        assertEquals(0.0f, result);
    }
    
    @Test
    void testCONSTInt() {
        int result = ObjectUtils.CONST(123);
        assertEquals(123, result);
        
        result = ObjectUtils.CONST(0);
        assertEquals(0, result);
    }
    
    @Test
    void testCONSTLong() {
        long result = ObjectUtils.CONST(123L);
        assertEquals(123L, result);
        
        result = ObjectUtils.CONST(0L);
        assertEquals(0L, result);
    }
    
    @Test
    void testCONSTShort() {
        short result = ObjectUtils.CONST((short) 123);
        assertEquals((short) 123, result);
        
        result = ObjectUtils.CONST((short) -123);
        assertEquals((short) -123, result);
    }
    
    @Test
    void testCONSTString() {
        String result = ObjectUtils.CONST("abc");
        assertEquals("abc", result);
        
        result = ObjectUtils.CONST("");
        assertEquals("", result);
    }
}