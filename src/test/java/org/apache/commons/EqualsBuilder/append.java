import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class appendTest {
    
    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }
    
    @Test
    void testAppend_boolean() {
        EqualsBuilder result = equalsBuilder.append(true, true);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_boolean_false() {
        EqualsBuilder result = equalsBuilder.append(true, false);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_booleanArray_null() {
        boolean[] lhs = null;
        boolean[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_booleanArray_lengthMismatch() {
        boolean[] lhs = {true, false};
        boolean[] rhs = {true};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_booleanArray_sameArray() {
        boolean[] lhs = {true, false};
        boolean[] rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_byte() {
        EqualsBuilder result = equalsBuilder.append((byte) 1, (byte) 1);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_byte_false() {
        EqualsBuilder result = equalsBuilder.append((byte) 1, (byte) 2);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_byteArray_null() {
        byte[] lhs = null;
        byte[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_byteArray_lengthMismatch() {
        byte[] lhs = {1, 2};
        byte[] rhs = {1};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_byteArray_sameArray() {
        byte[] lhs = {1, 2};
        byte[] rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_char() {
        EqualsBuilder result = equalsBuilder.append('a', 'a');
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_char_false() {
        EqualsBuilder result = equalsBuilder.append('a', 'b');
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_charArray_null() {
        char[] lhs = null;
        char[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_charArray_lengthMismatch() {
        char[] lhs = {'a', 'b'};
        char[] rhs = {'a'};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_charArray_sameArray() {
        char[] lhs = {'a', 'b'};
        char[] rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_double() {
        EqualsBuilder result = equalsBuilder.append(1.0, 1.0);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_double_false() {
        EqualsBuilder result = equalsBuilder.append(1.0, 2.0);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_doubleArray_null() {
        double[] lhs = null;
        double[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_doubleArray_lengthMismatch() {
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_doubleArray_sameArray() {
        double[] lhs = {1.0, 2.0};
        double[] rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_float() {
        EqualsBuilder result = equalsBuilder.append(1.0f, 1.0f);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_float_false() {
        EqualsBuilder result = equalsBuilder.append(1.0f, 2.0f);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_floatArray_null() {
        float[] lhs = null;
        float[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_floatArray_lengthMismatch() {
        float[] lhs = {1.0f, 2.0f};
        float[] rhs = {1.0f};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_floatArray_sameArray() {
        float[] lhs = {1.0f, 2.0f};
        float[] rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_int() {
        EqualsBuilder result = equalsBuilder.append(1, 1);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_int_false() {
        EqualsBuilder result = equalsBuilder.append(1, 2);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_intArray_null() {
        int[] lhs = null;
        int[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_intArray_lengthMismatch() {
        int[] lhs = {1, 2};
        int[] rhs = {1};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_intArray_sameArray() {
        int[] lhs = {1, 2};
        int[] rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_long() {
        EqualsBuilder result = equalsBuilder.append(1L, 1L);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_long_false() {
        EqualsBuilder result = equalsBuilder.append(1L, 2L);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_longArray_null() {
        long[] lhs = null;
        long[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_longArray_lengthMismatch() {
        long[] lhs = {1L, 2L};
        long[] rhs = {1L};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_longArray_sameArray() {
        long[] lhs = {1L, 2L};
        long[] rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_Object() {
        Object lhs = new Object();
        Object rhs = new Object();
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_Object_sameObject() {
        Object lhs = new Object();
        Object rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_ObjectArray_null() {
        Object[] lhs = null;
        Object[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_ObjectArray_lengthMismatch() {
        Object[] lhs = {new Object(), new Object()};
        Object[] rhs = {new Object()};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_ObjectArray_sameArray() {
        Object[] lhs = {new Object(), new Object()};
        Object[] rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_short() {
        EqualsBuilder result = equalsBuilder.append((short) 1, (short) 1);
        assertEquals(true, result.isEquals);
    }
    
    @Test
    void testAppend_short_false() {
        EqualsBuilder result = equalsBuilder.append((short) 1, (short) 2);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_shortArray_null() {
        short[] lhs = null;
        short[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_shortArray_lengthMismatch() {
        short[] lhs = {1, 2};
        short[] rhs = {1};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(false, result.isEquals);
    }
    
    @Test
    void testAppend_shortArray_sameArray() {
        short[] lhs = {1, 2};
        short[] rhs = lhs;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertEquals(true, result.isEquals);
    }
    
}
