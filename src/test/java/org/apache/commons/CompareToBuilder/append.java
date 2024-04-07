import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class appendTest {

    @Test
    public void testAppend_boolean() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, true);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(true, false);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(false, true);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(false, false);
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_booleanArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new boolean[]{true, true}, new boolean[]{true, true});
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new boolean[]{true, true}, new boolean[]{true, false});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new boolean[]{true, false}, new boolean[]{true, true});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new boolean[]{false, false}, new boolean[]{true, true});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new boolean[]{true, true}, new boolean[]{false, false});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new boolean[]{true, true});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new boolean[]{true, true}, null);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_byte() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append((byte) 1, (byte) 1);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append((byte) 1, (byte) 2);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append((byte) 2, (byte) 1);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append((byte) 1, (byte) 1);
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_byteArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new byte[]{1, 1}, new byte[]{1, 1});
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new byte[]{1, 1}, new byte[]{1, 2});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new byte[]{1, 2}, new byte[]{1, 1});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new byte[]{1, 1}, new byte[]{2, 2});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new byte[]{2, 2}, new byte[]{1, 1});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new byte[]{1, 1});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new byte[]{1, 1}, null);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_char() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append('a', 'a');
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append('a', 'b');
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append('b', 'a');
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append('a', 'a');
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_charArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new char[]{'a', 'a'}, new char[]{'a', 'a'});
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new char[]{'a', 'a'}, new char[]{'a', 'b'});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new char[]{'a', 'b'}, new char[]{'a', 'a'});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new char[]{'a', 'a'}, new char[]{'b', 'b'});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new char[]{'b', 'b'}, new char[]{'a', 'a'});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new char[]{'a', 'a'});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new char[]{'a', 'a'}, null);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_double() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1.0, 1.0);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(1.0, 2.0);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(2.0, 1.0);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(1.0, 1.0);
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_doubleArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new double[]{1.0, 1.0}, new double[]{1.0, 1.0});
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new double[]{1.0, 1.0}, new double[]{1.0, 2.0});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new double[]{1.0, 2.0}, new double[]{1.0, 1.0});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new double[]{1.0, 1.0}, new double[]{2.0, 2.0});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new double[]{2.0, 2.0}, new double[]{1.0, 1.0});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new double[]{1.0, 1.0});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new double[]{1.0, 1.0}, null);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_float() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1.0f, 1.0f);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(1.0f, 2.0f);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(2.0f, 1.0f);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(1.0f, 1.0f);
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_floatArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new float[]{1.0f, 1.0f}, new float[]{1.0f, 1.0f});
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new float[]{1.0f, 1.0f}, new float[]{1.0f, 2.0f});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new float[]{1.0f, 2.0f}, new float[]{1.0f, 1.0f});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new float[]{1.0f, 1.0f}, new float[]{2.0f, 2.0f});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new float[]{2.0f, 2.0f}, new float[]{1.0f, 1.0f});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new float[]{1.0f, 1.0f});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new float[]{1.0f, 1.0f}, null);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_int() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1, 1);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(1, 2);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(2, 1);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(1, 1);
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_intArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new int[]{1, 1}, new int[]{1, 1});
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new int[]{1, 1}, new int[]{1, 2});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new int[]{1, 2}, new int[]{1, 1});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new int[]{1, 1}, new int[]{2, 2});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new int[]{2, 2}, new int[]{1, 1});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new int[]{1, 1});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new int[]{1, 1}, null);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_long() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(1L, 1L);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(1L, 2L);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(2L, 1L);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(1L, 1L);
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_longArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new long[]{1L, 1L}, new long[]{1L, 1L});
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new long[]{1L, 1L}, new long[]{1L, 2L});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new long[]{1L, 2L}, new long[]{1L, 1L});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new long[]{1L, 1L}, new long[]{2L, 2L});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new long[]{2L, 2L}, new long[]{1L, 1L});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new long[]{1L, 1L});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new long[]{1L, 1L}, null);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_Object() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append("abc", "abc");
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append("abc", "def");
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append("def", "abc");
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append("abc", "abc");
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_ObjectArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, new Object[]{"abc", "def"});
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, new Object[]{"abc", "abc"});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "abc"}, new Object[]{"abc", "def"});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, new Object[]{"def", "abc"});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"def", "abc"}, new Object[]{"abc", "def"});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new Object[]{"abc", "def"});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, null);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_Object_Comparator() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append("abc", "abc", String.CASE_INSENSITIVE_ORDER);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append("abc", "def", String.CASE_INSENSITIVE_ORDER);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append("def", "abc", String.CASE_INSENSITIVE_ORDER);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append("abc", "abc", String.CASE_INSENSITIVE_ORDER);
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_ObjectArray_Comparator() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, new Object[]{"abc", "def"}, String.CASE_INSENSITIVE_ORDER);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, new Object[]{"abc", "abc"}, String.CASE_INSENSITIVE_ORDER);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "abc"}, new Object[]{"abc", "def"}, String.CASE_INSENSITIVE_ORDER);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, new Object[]{"def", "abc"}, String.CASE_INSENSITIVE_ORDER);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"def", "abc"}, new Object[]{"abc", "def"}, String.CASE_INSENSITIVE_ORDER);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new Object[]{"abc", "def"}, String.CASE_INSENSITIVE_ORDER);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, null, String.CASE_INSENSITIVE_ORDER);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_ObjectArray_nullComparator() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, new Object[]{"abc", "def"}, null);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, new Object[]{"abc", "abc"}, null);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "abc"}, new Object[]{"abc", "def"}, null);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, new Object[]{"def", "abc"}, null);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"def", "abc"}, new Object[]{"abc", "def"}, null);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new Object[]{"abc", "def"}, null);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new Object[]{"abc", "def"}, null, null);
        assertEquals(1, builder.toComparison());
    }
    
    @Test
    public void testAppend_short() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append((short) 1, (short) 1);
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append((short) 1, (short) 2);
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append((short) 2, (short) 1);
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append((short) 1, (short) 1);
        assertEquals(0, builder.toComparison());
    }
    
    @Test
    public void testAppend_shortArray() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(new short[]{1, 1}, new short[]{1, 1});
        assertEquals(0, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new short[]{1, 1}, new short[]{1, 2});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new short[]{1, 2}, new short[]{1, 1});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new short[]{1, 1}, new short[]{2, 2});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new short[]{2, 2}, new short[]{1, 1});
        assertEquals(1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(null, new short[]{1, 1});
        assertEquals(-1, builder.toComparison());
        
        builder = new CompareToBuilder();
        builder.append(new short[]{1, 1}, null);
        assertEquals(1, builder.toComparison());
    }
}